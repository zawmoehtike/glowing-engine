package co.codigo.tmdbexample.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import co.codigo.tmdbexample.R
import co.codigo.tmdbexample.data.networkvos.MovieVO
import co.codigo.tmdbexample.delegates.PopularDelegate
import co.codigo.tmdbexample.utils.UiHelpers
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_holder_movie.view.*

class PopularAdapter(context: Context, private var popularDelegate: PopularDelegate) : BaseRecyclerAdapter<PopularAdapter.PopularViewHolder, MovieVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<MovieVO> {
        // create a new view
        val v = mLayoutInflator.inflate(R.layout.view_holder_movie, parent, false)
        return PopularViewHolder(v, popularDelegate)
    }

    class PopularViewHolder(v: View, private var popularDelegate: PopularDelegate) : BaseViewHolder<MovieVO>(v) {
        override fun setData(data: MovieVO) {
            itemView.tvTitle.text = data.title
            itemView.tvDescription.text = data.overview
            itemView.tvLikeCount.text = data.voteAverage

            Glide.with(itemView.context)
                .load(UiHelpers.buildImageUrl(data.posterPath?:""))
                .placeholder(R.drawable.ic_blank_image)
                .into(itemView.ivMovie)

            itemView.ivLike.setOnClickListener {
                data.liked = !data.liked
                if(data.liked) {
                    Glide.with(itemView.context)
                        .load(R.drawable.ic_like)
                        .placeholder(R.drawable.ic_blank_image)
                        .into(itemView.ivLike)
                } else {
                    Glide.with(itemView.context)
                        .load(R.drawable.ic_unlike)
                        .placeholder(R.drawable.ic_blank_image)
                        .into(itemView.ivLike)
                }
            }

            itemView.ivMovie.setOnClickListener {
                popularDelegate.clickPopular(data.id!!)
            }
        }

        override fun onClick(p0: View?) {

        }
    }
}