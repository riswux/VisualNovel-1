package com.example.labwork1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.labwork1.databinding.ActivityGameScreenBinding


class GameScreen : AppCompatActivity() {

    lateinit var binding: ActivityGameScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val story = Story(binding)

        story.inputPoint()

        binding.choiceButton1.setOnClickListener{
            story.selectedPosition(story.nextPosition1)
        }
        binding.choiceButton2.setOnClickListener{
            story.selectedPosition(story.nextPosition2)
        }
        binding.choiceButton3.setOnClickListener{
            story.selectedPosition(story.nextPosition3)
        }
    }
}

