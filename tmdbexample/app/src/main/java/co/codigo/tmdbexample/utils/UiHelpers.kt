package co.codigo.tmdbexample.utils

object UiHelpers {
    fun buildImageUrl(path: String): String {
        return "http://image.tmdb.org/t/p/w342" + path
    }
}