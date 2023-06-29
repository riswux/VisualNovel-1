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

class Story(private val binding: ActivityGameScreenBinding) {

    var nextPosition1= "";
    var nextPosition2= "";
    var nextPosition3= "";

    fun showAllbuttons(){
        binding.choiceButton1.setVisibility(View.VISIBLE)
        binding.choiceButton2.setVisibility(View.VISIBLE)
        binding.choiceButton3.setVisibility(View.VISIBLE)
    }
    fun selectedPosition(position: String){

        val mainActivity = MainActivity()

        when(position){
            "inputPoint" -> inputPoint()
            "startingPoint" -> startingPoint()
            "walking" -> walking()
            "hiking" -> hiking()
            "field" -> field()
            "film" -> film()
            "likefilm" -> likefilm()
            "dislikefilm" -> dislikefilm()
            "halloween" -> halloween()
            "costom" -> costom()
            "likecostom" -> likecostom()
            "dislikecostom" -> dislikecostom()
            "endPoint" -> endPoint()
            "goTitleScreen" ->  mainActivity.goToTitleScreen()

        }

    }

    fun updateGameState(
        imageResource: Int,
        gameText: String,
        choiceButton1Text: String,
        choiceButton2Text: String,
        choiceButton3Text: String,
        nextPosition1Value: String,
        nextPosition2Value: String,
        nextPosition3Value: String) {
        setGameViews(imageResource, gameText)
        setChoiceButtons(choiceButton1Text, choiceButton2Text, choiceButton3Text)
        updateNextPositions(nextPosition1Value, nextPosition2Value, nextPosition3Value)
    }

    fun setGameViews(imageResource: Int, gameText: String) {
        binding.gameView.setImageResource(imageResource)
        binding.gameTextView.setText(gameText)
        binding.gameMC.setVisibility(View.INVISIBLE)
        binding.inputName.setVisibility(View.INVISIBLE)
    }

    fun setChoiceButtons(choiceButton1Text: String, choiceButton2Text: String, choiceButton3Text: String) {
        binding.choiceButton1.setText(choiceButton1Text)
        binding.choiceButton2.setText(choiceButton2Text)
        binding.choiceButton3.setText(choiceButton3Text)
        binding.choiceButton1.setVisibility(if (choiceButton1Text.isEmpty()) View.INVISIBLE else View.VISIBLE)
    }

    fun updateNextPositions(nextPosition1Value: String, nextPosition2Value: String, nextPosition3Value: String) {
        nextPosition1 = nextPosition1Value
        nextPosition2 = nextPosition2Value
        nextPosition3 = nextPosition3Value
    }


    fun inputPoint(){
        binding.gameTextView.setText("Hello! My name is Jack. And you?")
        binding.inputName.setVisibility(View.VISIBLE)
        binding.choiceButton1.setVisibility(View.INVISIBLE)
        binding.choiceButton2.setVisibility(View.INVISIBLE)

        setChoiceButtons("", "", "Accept")
        updateNextPositions("", "", "startingPoint")

    }

    fun startingPoint(){
        updateGameState(
            R.drawable.backgroud1,
            "",
            "Walking",
            "Hiking",
            "Go to the field",
            "walking",
            "Hiking",
            "Go to the field")

        val inputEditText = binding.inputName.editText
        val username = inputEditText?.text.toString()

        binding.gameTextView.text = "Great, $username! What are we going to do?"
        binding.inputName.setVisibility(View.INVISIBLE)
        showAllbuttons()
    }


    fun walking() {
        updateGameState(
            R.drawable.walking,
            "Maybe go home?",
            "",
            "Yes, and watch film",
            "Yes, and celebrate Halloween",
            "",
            "film",
            "halloween")
    }

    fun hiking() {
        updateGameState(
            R.drawable.hiking,
            "How cozy... But it’s already getting dark...",
            "",
            "Go home and watch the film",
            "Go home and celebrate Halloween",
            "",
            "film",
            "halloween")
    }

    fun field() {
        updateGameState(
            R.drawable.field,
            "You are sad... Let’s go home?",
            "",
            "Maybe, let’s watch the film?",
            "Yes, let’s celebrate the Halloween",
            "",
            "film",
            "halloween")
    }

    fun film() {
        updateGameState(R.drawable.film,
            "Do you like this film?",
            "",
            "I like it!",
            "No...",
            "",
            "likefilm",
            "dislikefilm")
    }

    fun likefilm() {
        updateGameState(
            R.drawable.film,
            "Great! It’s time to sleep...",
            "Yes, it’s too late...",
            "",
            "",
            "endPoint",
            "",
            "")
    }

    fun dislikefilm() {
        updateGameState(
            R.drawable.film,
            "May be go sleep?",
            "Yes, it’s too late...",
            "",
            "",
            "endPoint",
            "",
            "")
    }

    fun halloween() {
        updateGameState(
            R.drawable.costum,
            "Very beautiful!",
            "",
            "Yes! Let’s watch the film!",
            "Yes! Let’s create costume!",
            "",
            "film",
            "costom")
    }

    fun costom() {
        updateGameState(
            R.drawable.haloween,
            "I like your costume.",
            "",
            "Your costume is beautiful too!",
            "To tell you the truth, I don’t like your...",
            "",
            "likecostom",
            "dislikecostom")
    }

    fun likecostom() {
        updateGameState(
            R.drawable.haloween,
            "Thank you! Let’s go to sleep.",
            "Yes, it’s too late...",
            "",
            "",
            "endPoint",
            "",
            "")
    }

     fun dislikecostom() {
        updateGameState(
            R.drawable.haloween,
            "It’s ok, I’m not taking offense. Let’s go to sleep!",
            "Yes, it’s too late...",
            "",
            "",
            "endPoint",
            "",
            "")
    }


    fun endPoint(){
        binding.gameView.setImageResource(R.drawable.backgroud1)

        binding.inputName.setVisibility(View.INVISIBLE)

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

        nextPosition1= "goTitleScreen"
    }


}
