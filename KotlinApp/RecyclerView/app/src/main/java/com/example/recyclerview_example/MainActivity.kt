package com.example.recyclerview_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_example.databinding.ActivityMainBinding


    private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val profillist = arrayListOf(
            Profile(R.drawable.img, "김연우", 17,"안드로이드 개발자"),
            Profile(R.drawable.img,"김철우", 17, "백엔드 개발자"),
            Profile(R.drawable.img, "김은오", 17, "백엔드 개발자"),
            Profile(R.drawable.img, "박주영", 17,"ios 개발자"),
            Profile(R.drawable.img, "양운석", 17, "백엔드 개발자")
        )

        binding.rvProfile.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = ProfileAdapter(profillist)


    }
}