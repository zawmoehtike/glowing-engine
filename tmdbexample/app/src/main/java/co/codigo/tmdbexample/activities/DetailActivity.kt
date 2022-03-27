package co.codigo.tmdbexample.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import co.codigo.tmdbexample.R
import co.codigo.tmdbexample.utils.UiHelpers
import co.codigo.tmdbexample.viewmodels.DetailViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    private var id: String = ""
    private lateinit var mViewModel: DetailViewModel

    companion object {
        fun newIntent(
            context: Context?,
            id: String
        ): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("id", id)
            return intent
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        mViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        observe()

        id = intent.getStringExtra("id")?:""

        initUI()

        loadingDetail.visibility = View.VISIBLE
        mViewModel.callMovieDetail(id)
    }

    private fun initUI() {
        tvRetryDetail.setOnClickListener {
            tvRetryDetail.visibility = View.GONE
            loadingDetail.visibility = View.VISIBLE

            mViewModel.callMovieDetail(id)
        }
    }

    private fun observe() {
        val movieDetailResponse = mViewModel.getMovieDetailResponse()
        movieDetailResponse.observe(this, Observer { apiResponse ->
            if (apiResponse.error!!.code == 0) {
                layoutSuccess.visibility = View.VISIBLE
                loadingDetail.visibility = View.GONE
                tvRetryDetail.visibility = View.GONE

                Glide.with(this)
                    .load(UiHelpers.buildImageUrl(apiResponse.backdropPath?:""))
                    .centerCrop()
                    .placeholder(R.drawable.ic_blank_image)
                    .into(ivMovie)
            } else {
                layoutSuccess.visibility = View.GONE
                loadingDetail.visibility = View.GONE
                tvRetryDetail.visibility = View.VISIBLE
            }
        })
    }
}