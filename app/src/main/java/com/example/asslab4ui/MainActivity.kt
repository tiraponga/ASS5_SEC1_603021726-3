package com.example.asslab4ui

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btn_pickDate.setOnClickListener{
            val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{ view, mYear, mMonth, mDay ->
                    text_date.setText(""+mDay+"/"+mMonth+"/"+mYear)
                },year, month, day)
            dpd.show()
        }
    }
    fun radio_button_click(view: View){
        // Get the clicked radio button instance
        val radio: RadioButton = findViewById(group.checkedRadioButtonId)
        Toast.makeText(applicationContext,"On click : ${radio.text}", Toast.LENGTH_SHORT).show()
    }

    fun showDetail(view: View){
        val radio: RadioButton = findViewById(group.checkedRadioButtonId)
        text_show.text = "Username: ${edit_id.text}\nPassword: ${edit_name.text}\nGender: ${radio.text}\nEmail: ${edit_email.text} \nTime: ${text_date.text}"
    }
    fun reset(v: View){
        edit_id.text.clear()
        edit_name.text.clear()
        group.clearCheck()
        edit_email.text.clear()
        text_date.text="dd / mm / yyyy"
        text_show.text ="Show detail"
    }
}

