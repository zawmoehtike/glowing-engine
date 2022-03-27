package co.codigo.tmdbexample

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import co.codigo.tmdbexample.data.TmdbExampleAppModel

class TmdbExampleApplication: Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()
        TmdbExampleAppModel.initAppModel(applicationContext)
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }
}