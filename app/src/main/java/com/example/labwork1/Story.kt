package com.example.labwork1

import android.content.res.ColorStateList
import android.graphics.Color

import android.util.TypedValue
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.labwork1.databinding.ActivityGameScreenBinding
import com.google.gson.Gson
import java.io.File
import java.io.FileWriter


enum class Position {
    INPUT_POINT,
    STARTING_POINT,
    WALKING,
    HIKING,
    FIELD,
    FILM,
    LIKE_FILM,
    DISLIKE_FILM,
    HALLOWEEN,
    COSTUME,
    LIKE_COSTUME,
    DISLIKE_COSTUME,
    END_POINT,
    GO_TITLE_SCREEN
}

class Story(private val binding: ActivityGameScreenBinding) {


    private var nextPositions: MutableList<Position> = mutableListOf()

    fun showAllButtons() {
        binding.choiceButton1.visibility = View.VISIBLE
        binding.choiceButton2.visibility = View.VISIBLE
        binding.choiceButton3.visibility = View.VISIBLE
    }

    fun selectedPosition(position: Position) {
        val mainActivity = MainActivity()

        when (position) {
            Position.INPUT_POINT -> inputPoint()
            Position.STARTING_POINT -> startingPoint()
            Position.WALKING -> walking()
            Position.HIKING -> hiking()
            Position.FIELD -> field()
            Position.FILM -> film()
            Position.LIKE_FILM -> likeFilm()
            Position.DISLIKE_FILM -> dislikeFilm()
            Position.HALLOWEEN -> halloween()
            Position.COSTUME -> costume()
            Position.LIKE_COSTUME -> likeCostume()
            Position.DISLIKE_COSTUME -> dislikeCostume()
            Position.END_POINT -> endPoint()
            Position.GO_TITLE_SCREEN -> mainActivity.goToTitleScreen()
        }
    }

    fun updateGameState(
        imageResource: Int,
        gameText: String,
        choiceButton1Text: String,
        choiceButton2Text: String,
        choiceButton3Text: String,
        vararg positions: Position
    ) {
        setGameViews(imageResource, gameText)
        setChoiceButtons(choiceButton1Text, choiceButton2Text, choiceButton3Text)
        updateNextPositions(*positions)
    }

    fun setGameViews(imageResource: Int, gameText: String) {
        binding.gameView.setImageResource(imageResource)
        binding.gameTextView.text = gameText
        binding.gameMC.visibility = View.INVISIBLE
        binding.inputName.visibility = View.INVISIBLE
    }

    fun setChoiceButtons(choiceButton1Text: String, choiceButton2Text: String, choiceButton3Text: String) {
        binding.choiceButton1.text = choiceButton1Text
        binding.choiceButton2.text = choiceButton2Text
        binding.choiceButton3.text = choiceButton3Text
        binding.choiceButton1.visibility = if (choiceButton1Text.isEmpty()) View.INVISIBLE else View.VISIBLE
    }

    fun updateNextPositions(vararg positions: Position) {
        nextPositions.clear()
        nextPositions.addAll(positions)
    }

    fun inputPoint() {
        binding.gameTextView.text = "Hello! My name is Jack. And you?"
        binding.inputName.visibility = View.VISIBLE
        binding.choiceButton1.visibility = View.INVISIBLE
        binding.choiceButton2.visibility = View.INVISIBLE

        setChoiceButtons("", "", "Accept")
        updateNextPositions(Position.STARTING_POINT)
    }

    fun startingPoint() {
        updateGameState(
            R.drawable.backgroud1,
            "",
            "Walking",
            "Hiking",
            "Go to the field",
            Position.WALKING,
            Position.HIKING,
            Position.FIELD
        )

        val inputEditText = binding.inputName.editText
        val username = inputEditText?.text.toString()

        binding.gameTextView.text = "Great, $username! What are we going to do?"
        binding.inputName.visibility = View.INVISIBLE
        showAllButtons()
    }

    fun walking() {
        updateGameState(
            R.drawable.walking,
            "Maybe go home?",
            "",
            "Yes, and watch film",
            "Yes, and celebrate Halloween",
            Position.FILM,
            Position.HALLOWEEN
        )
    }

    fun hiking() {
        updateGameState(
            R.drawable.hiking,
            "How cozy... But it’s already getting dark...",
            "",
            "Go home and watch the film",
            "Go home and celebrate Halloween",
            Position.FILM,
            Position.HALLOWEEN
        )
    }

    fun field() {
        updateGameState(
            R.drawable.field,
            "You are sad... Let’s go home?",
            "",
            "Maybe, let’s watch the film?",
            "Yes, let’s celebrate the Halloween",
            Position.FILM,
            Position.HALLOWEEN
        )
    }

    fun film() {
        updateGameState(
            R.drawable.film,
            "Do you like this film?",
            "",
            "I like it!",
            "No...",
            Position.LIKE_FILM,
            Position.DISLIKE_FILM
        )
    }

    fun likeFilm() {
        updateGameState(
            R.drawable.film,
            "Great! It’s time to sleep...",
            "Yes, it’s too late...",
            "",
            "",
            Position.END_POINT
        )
    }

    fun dislikeFilm() {
        updateGameState(
            R.drawable.film,
            "Maybe go sleep?",
            "Yes, it’s too late...",
            "",
            "",
            Position.END_POINT
        )
    }

    fun halloween() {
        updateGameState(
            R.drawable.costum,
            "Very beautiful!",
            "",
            "Yes! Let’s watch the film!",
            "Yes! Let’s create costume!",
            Position.FILM,
            Position.COSTUME
        )
    }

    fun costume() {
        updateGameState(
            R.drawable.haloween,
            "I like your costume.",
            "",
            "Your costume is beautiful too!",
            "To tell you the truth, I don’t like your...",
            Position.LIKE_COSTUME,
            Position.DISLIKE_COSTUME
        )
    }

    fun likeCostume() {
        updateGameState(
            R.drawable.haloween,
            "Thank you! Let’s go to sleep.",
            "Yes, it’s too late...",
            "",
            "",
            Position.END_POINT
        )
    }

    fun dislikeCostume() {
        updateGameState(
            R.drawable.haloween,
            "It’s ok, I’m not taking offense. Let’s go to sleep!",
            "Yes, it’s too late...",
            "",
            "",
            Position.END_POINT
        )
    }

    fun endPoint() {
        binding.gameView.setImageResource(R.drawable.backgroud1)

        binding.inputName.visibility = View.INVISIBLE

        binding.gameTextView.apply {
            text = "Thank You for playing!"
            textSize = 36f // 20sp
            setTextColor(Color.WHITE)
            setBackgroundColor(Color.parseColor("#659CB8"))
            textAlignment = View.TEXT_ALIGNMENT_CENTER

            val resources = binding.gameTextView.resources
            val layoutParams = binding.gameTextView.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                420f,
                resources.displayMetrics
            ).toInt()
            layoutParams.height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                97f,
                resources.displayMetrics
            ).toInt()
            layoutParams.verticalBias = 0.367f // between 0 and 1
            binding.gameTextView.layoutParams = layoutParams
        }

        binding.choiceButton1.apply {
            text = "Repeat the Game"
            backgroundTintList = ColorStateList.valueOf(Color.parseColor("#275168"))
        }

        updateNextPositions(Position.GO_TITLE_SCREEN)
    }
}
