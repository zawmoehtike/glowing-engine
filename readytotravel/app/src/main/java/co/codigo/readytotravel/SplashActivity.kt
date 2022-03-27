package co.codigo.readytotravel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_actvitiy.*

class SplashActivity : AppCompatActivity() {

    companion object {
        fun newIntent(
            context: Context?
        ): Intent? {
            val intent = Intent(context, SplashActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_actvitiy)

        btnCreateNewAccount.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }
    }
}