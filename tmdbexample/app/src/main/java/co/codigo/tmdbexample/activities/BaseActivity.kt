package co.codigo.tmdbexample.activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import co.codigo.tmdbexample.R
import co.codigo.tmdbexample.utils.components.LoadingDialog

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
open class BaseActivity : AppCompatActivity() {

    lateinit var mLoadingDialog: LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        mLoadingDialog = LoadingDialog(
            this,
            getString(R.string.loading_dot_dot_dot),
            getString(R.string.loading)
        )
    }
}