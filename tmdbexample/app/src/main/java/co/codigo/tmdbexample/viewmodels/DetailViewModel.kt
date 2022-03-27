package co.codigo.tmdbexample.viewmodels

import androidx.lifecycle.MutableLiveData
import co.codigo.tmdbexample.data.TmdbExampleAppModel
import co.codigo.tmdbexample.data.responses.MovieDetailResponse

class DetailViewModel: BaseViewModel() {
    private var movieDetailResponse: MutableLiveData<MovieDetailResponse> = MutableLiveData()

    fun callMovieDetail(id: String){
        TmdbExampleAppModel.getInstance().callMovieDetail(movieDetailResponse, id)
    }

    fun getMovieDetailResponse(): MutableLiveData<MovieDetailResponse> {
        return movieDetailResponse
    }
}