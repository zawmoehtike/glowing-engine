package co.codigo.tmdbexample.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import co.codigo.tmdbexample.R
import co.codigo.tmdbexample.data.networkvos.ErrorVO
import co.codigo.tmdbexample.data.responses.MovieDetailResponse
import co.codigo.tmdbexample.data.responses.PopularResponse
import co.codigo.tmdbexample.data.responses.UpcomingResponse
import co.codigo.tmdbexample.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TmdbExampleAppModel(context: Context) : BaseModel(context) {

    companion object {
        private var INSTANCE: TmdbExampleAppModel? = null
        private lateinit var mContext: Context

        fun getInstance(): TmdbExampleAppModel {
            if (INSTANCE == null) {
                throw RuntimeException("JojoStore is being invoked before initializing")
            }
            return INSTANCE as TmdbExampleAppModel
        }

        fun initAppModel(context: Context) {
            INSTANCE = TmdbExampleAppModel(context)
            mContext = context
        }
    }

    fun callPopular(apiResponse: MutableLiveData<PopularResponse>?): Disposable? {
        var response: PopularResponse = PopularResponse()
        return mTheApi.callPopular(
            Constants.API_KEY
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    response = result
                    val errorVO = ErrorVO(0, mContext.getString(R.string.success))
                    response.error = errorVO
                    apiResponse!!.value = response
                },
                { _ ->
                    val errorVO = ErrorVO(111, mContext.getString(R.string.connection_problem))
                    response.error = errorVO
                    apiResponse!!.value = response
                })
    }

    fun callUpcoming(apiResponse: MutableLiveData<UpcomingResponse>?): Disposable? {
        var response: UpcomingResponse = UpcomingResponse()
        return mTheApi.callUpcoming(
            Constants.API_KEY
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    response = result
                    val errorVO = ErrorVO(0, mContext.getString(R.string.success))
                    response.error = errorVO
                    apiResponse!!.value = response
                },
                { _ ->
                    val errorVO = ErrorVO(111, mContext.getString(R.string.connection_problem))
                    response.error = errorVO
                    apiResponse!!.value = response
                })
    }

    fun callMovieDetail(apiResponse: MutableLiveData<MovieDetailResponse>?, id: String): Disposable? {
        var response: MovieDetailResponse = MovieDetailResponse()
        return mTheApi.callMovieDetail(
            id,
            Constants.API_KEY
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    response = result
                    val errorVO = ErrorVO(0, mContext.getString(R.string.success))
                    response.error = errorVO
                    apiResponse!!.value = response
                },
                { _ ->
                    val errorVO = ErrorVO(111, mContext.getString(R.string.connection_problem))
                    response.error = errorVO
                    apiResponse!!.value = response
                })
    }
}