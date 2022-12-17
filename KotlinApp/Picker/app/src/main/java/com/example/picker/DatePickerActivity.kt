package com.example.picker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar

class DatePickerActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datepicker)


        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        textView.text = """
                        초기 설정된 날짜 [년도/월/일]
                        $year/${month+1}/$dayOfMonth
                        """.trimIndent()

        button.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        val textView = findViewById<TextView>(R.id.textView)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)

        if(view?.id == R.id.button) {
            textView.text = "초기 설정된 날짜 [년도/월/일] : \n" + datePicker.year.toString() + "/" +
                    (datePicker.month + 1).toString() + "/" + datePicker.dayOfMonth.toString()
        }
    }
}
