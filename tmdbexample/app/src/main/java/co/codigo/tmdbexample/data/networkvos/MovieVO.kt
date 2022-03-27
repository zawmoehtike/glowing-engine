package co.codigo.tmdbexample.data.networkvos

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieVO(
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("title")
    @Expose
    var title: String? = null,
    @SerializedName("overview")
    @Expose
    var overview: String? = null,
    @SerializedName("vote_average")
    @Expose
    var voteAverage: String? = null,
    @SerializedName("backdrop_path")
    @Expose
    var backdropPath: String? = null,
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null,

    @Expose
    var liked: Boolean = false
)