package co.codigo.tmdbexample.data

import android.content.Context
import co.codigo.tmdbexample.data.networks.TmdbExampleApi
import co.codigo.tmdbexample.utils.Constants
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel protected constructor(context: Context) {
    protected var mTheApi : TmdbExampleApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(180, TimeUnit.SECONDS)
            .writeTimeout(180,TimeUnit.SECONDS)
            .readTimeout(100,TimeUnit.SECONDS)
            .build()
        val gSon = GsonBuilder()
                .setLenient()
                .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gSon))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        mTheApi = retrofit.create(TmdbExampleApi::class.java)
    }
}