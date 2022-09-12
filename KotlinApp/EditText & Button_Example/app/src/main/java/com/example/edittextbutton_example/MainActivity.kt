package com.example.edittextbutton_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.edittextbutton_example.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.BtnTest.setOnClickListener{
            var resultText = binding.EditTest.text.toString()
            binding.textView.setText(resultText)
        }
    }
}

