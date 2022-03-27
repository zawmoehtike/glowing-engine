package co.codigo.tmdbexample.viewmodels

import androidx.lifecycle.MutableLiveData
import co.codigo.tmdbexample.data.TmdbExampleAppModel
import co.codigo.tmdbexample.data.responses.PopularResponse
import co.codigo.tmdbexample.data.responses.UpcomingResponse

class HomeViewModel: BaseViewModel() {
    private var popularResponse: MutableLiveData<PopularResponse> = MutableLiveData()

    fun callPopular(){
        TmdbExampleAppModel.getInstance().callPopular(popularResponse)
    }

    fun getPopularResponse(): MutableLiveData<PopularResponse> {
        return popularResponse
    }

    private var upcomingResponse: MutableLiveData<UpcomingResponse> = MutableLiveData()

    fun callUpcoming(){
        TmdbExampleAppModel.getInstance().callUpcoming(upcomingResponse)
    }

    fun getUpcomingResponse(): MutableLiveData<UpcomingResponse> {
        return upcomingResponse
    }
}