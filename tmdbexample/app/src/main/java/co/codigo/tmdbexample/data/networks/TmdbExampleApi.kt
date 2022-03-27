package co.codigo.tmdbexample.data.networks

import co.codigo.tmdbexample.data.responses.MovieDetailResponse
import co.codigo.tmdbexample.data.responses.PopularResponse
import co.codigo.tmdbexample.data.responses.UpcomingResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbExampleApi {
    @GET("/3/movie/popular")
    fun callPopular(
        @Query("api_key") apiKey: String
    ): Observable<PopularResponse>

    @GET("/3/movie/upcoming")
    fun callUpcoming(
        @Query("api_key") apiKey: String
    ): Observable<UpcomingResponse>

    @GET("/3/movie/{movieId}")
    fun callMovieDetail(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String
    ): Observable<MovieDetailResponse>
}