package view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.Activity.R
import com.Activity.databinding.ActivitySetnumBinding
import viewModel.MainViewModel
import kotlin.properties.ReadOnlyProperty

class SetMaxActivity : AppCompatActivity() {
    private lateinit var mbind : ActivitySetnumBinding

    private val model : MainViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbind = DataBindingUtil.setContentView(this, R.layout.activity_setnum)

        mbind.lifecycleOwner = this
        mbind.viewmodelSetMaxNum = MainViewModel()

        var max : EditText = findViewById(R.id.maxnum)
        var completeBtn : Button = findViewById(R.id.complete)

        completeBtn.setOnClickListener{
            model.setMaxNum(Integer.parseInt(max.text.toString()))
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
