package co.codigo.tmdbexample.data.responses

import co.codigo.tmdbexample.data.networkvos.MovieVO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UpcomingResponse: BaseResponse() {
    @SerializedName("results")
    @Expose
    var results: List<MovieVO>? = ArrayList(0)
}