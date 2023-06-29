package com.example.labwork1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labwork1.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startButton.setOnClickListener{

            val Intent = Intent(this, GameScreen::class.java)
            startActivity(Intent)
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }
    fun goToTitleScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}