package co.codigo.tmdbexample.data.responses

import co.codigo.tmdbexample.data.networkvos.ErrorVO
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @SerializedName("error")
    @Expose
    var error: ErrorVO? = null
}