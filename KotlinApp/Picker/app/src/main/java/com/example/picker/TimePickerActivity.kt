package com.example.picker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TimePickerActivity : AppCompatActivity(), TimePicker.OnTimeChangedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timepicker)

        var cal = Calendar.getInstance()
        val hour = cal.get(Calendar.HOUR_OF_DAY)
        val minute = cal.get(Calendar.MINUTE)

        val textView = findViewById<TextView>(R.id.textView)
        val timePicker = findViewById<TimePicker>(R.id.timePicker)

        textView.text = "현재 설정된 시간 : \n 시:분 | $hour : $minute"
        timePicker.setOnTimeChangedListener(this)
    }

    override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "현재 설정된 시간 : \n 시:분 | $hourOfDay : $minute"
    }
}
