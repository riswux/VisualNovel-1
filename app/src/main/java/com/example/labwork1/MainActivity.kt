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
/*    fun saveScenarioList(context: Context, scenarioList: List<Scenario>, fileName: String) {
        val gson = Gson()
        val json = gson.toJson(scenarioList)
        val file = File(context.filesDir, fileName)
        file.writeText(json)
    }

    fun loadScenarioList(context: Context, fileName: String): List<Scenario> {
        val file = File(context.filesDir, fileName)
        val json = file.readText()
        val type = object : TypeToken<List<Scenario>>() {}.type
        return Gson().fromJson(json, type)
    }*/

}