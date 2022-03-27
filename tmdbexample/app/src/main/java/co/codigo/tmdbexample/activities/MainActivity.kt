package co.codigo.tmdbexample.activities

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import co.codigo.tmdbexample.R
import co.codigo.tmdbexample.adapters.PopularAdapter
import co.codigo.tmdbexample.adapters.UpcomingAdapter
import co.codigo.tmdbexample.delegates.PopularDelegate
import co.codigo.tmdbexample.delegates.UpcomingDelegate
import co.codigo.tmdbexample.viewmodels.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), PopularDelegate, UpcomingDelegate {

    private lateinit var mPopularAdapter: PopularAdapter
    private lateinit var mUpcomingAdapter: UpcomingAdapter

    private lateinit var mViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        observe()

        initUI()

        loadingUpcoming.visibility = View.VISIBLE
        mViewModel.callUpcoming()

        loadingPopular.visibility = View.VISIBLE
        mViewModel.callPopular()
    }

    private fun initUI() {
        mPopularAdapter = PopularAdapter(this, this)
        rvPopular.setHasFixedSize(true)
        rvPopular.layoutManager = LinearLayoutManager(this)
        rvPopular.itemAnimator = DefaultItemAnimator()
        rvPopular.adapter = mPopularAdapter

        mUpcomingAdapter = UpcomingAdapter(this, this)
        rvUpcoming.setHasFixedSize(true)
        rvUpcoming.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvUpcoming.itemAnimator = DefaultItemAnimator()
        rvUpcoming.adapter = mUpcomingAdapter

        tvRetryUpcoming.setOnClickListener {
            tvRetryUpcoming.visibility = View.GONE
            loadingUpcoming.visibility = View.VISIBLE

            mViewModel.callUpcoming()
        }

        tvRetryPopular.setOnClickListener {
            tvRetryPopular.visibility = View.GONE
            loadingPopular.visibility = View.VISIBLE

            mViewModel.callPopular()
        }
    }

    private fun observe() {
        val upcomingResponse = mViewModel.getUpcomingResponse()
        upcomingResponse.observe(this, Observer { apiResponse ->
            if (apiResponse.error!!.code == 0) {
                rvUpcoming.visibility = View.VISIBLE
                loadingUpcoming.visibility = View.GONE

                mUpcomingAdapter.setNewDataList(apiResponse.results?:ArrayList(0))
            } else {
                rvUpcoming.visibility = View.GONE
                loadingUpcoming.visibility = View.GONE
                tvRetryUpcoming.visibility = View.VISIBLE

                rvPopular.visibility = View.GONE
                loadingPopular.visibility = View.GONE
                tvRetryPopular.visibility = View.VISIBLE
            }
        })

        val popularResponse = mViewModel.getPopularResponse()
        popularResponse.observe(this, Observer { apiResponse ->
            if (apiResponse.error!!.code == 0) {
                rvPopular.visibility = View.VISIBLE
                loadingPopular.visibility = View.GONE

                mPopularAdapter.setNewDataList(apiResponse.results?:ArrayList(0))
            } else {
                rvPopular.visibility = View.GONE
                loadingPopular.visibility = View.GONE
                tvRetryPopular.visibility = View.VISIBLE
            }
        })
    }

    private fun goDetailScreen(id: String) {
        startActivity(DetailActivity.newIntent(this, id))
    }

    override fun clickPopular(id: String) {
        goDetailScreen(id)
    }

    override fun clickUpcoming(id: String) {
        goDetailScreen(id)
    }
}