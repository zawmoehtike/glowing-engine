package co.codigo.tmdbexample.utils.components

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import co.codigo.tmdbexample.R
import kotlinx.android.synthetic.main.dialog_loading.*

class LoadingDialog(context: Context, private var message: String, var title: String) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCanceledOnTouchOutside(false)
        setContentView(R.layout.dialog_loading)
        tvMessage.text = message
        tvTitle.text = title
        window?.setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
    }
}