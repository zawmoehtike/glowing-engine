package co.codigo.tmdbexample.data.networks

data class ApiResponse<T> (
    var data: T? = null,
    var error: Throwable? = null
)
