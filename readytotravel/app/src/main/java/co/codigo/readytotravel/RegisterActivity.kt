package co.codigo.readytotravel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.activity_register.*
import java.util.*

class RegisterActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private var dateOfBirth: String = ""

    companion object {
        fun newIntent(
            context: Context?
        ): Intent {
            val intent = Intent(context, RegisterActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        ivBack.setOnClickListener {
            finish()
        }

        etDOB.setOnClickListener {
            val now: Calendar = Calendar.getInstance()
            val dpd: DatePickerDialog = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),  // Initial year selection
                now.get(Calendar.MONTH),  // Initial month selection
                now.get(Calendar.DAY_OF_MONTH) // Inital day selection
            )
            dpd.maxDate = now
            dpd.show(supportFragmentManager, "Datepickerdialog")
        }

        btnCreateMyAccountNow.setOnClickListener {
            if(etFirstName.text.toString().trim() == "") {
                Toast.makeText(this, "First name is required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(etLastName.text.toString().trim() == "") {
                Toast.makeText(this, "Last name is required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(etEmailAddress.text.toString().trim() == "") {
                Toast.makeText(this, "Email address is required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(dateOfBirth == "") {
                Toast.makeText(this, "Date of birth is required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(!InputCheckerUtil.validateEmailAddress(etEmailAddress.text.toString())) {
                Toast.makeText(this, "Invalid email address!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(etMobileNo.text.toString().trim() != "" &&
                !InputCheckerUtil.validatePhoneNumber(etMobileNo.text.toString())) {
                Toast.makeText(this, "Invalid mobile number!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        dateOfBirth = dayOfMonth.toString() + "/" + monthOfYear.toString() + "/" + year.toString()
        etDOB.setText(dateOfBirth)
    }
}
