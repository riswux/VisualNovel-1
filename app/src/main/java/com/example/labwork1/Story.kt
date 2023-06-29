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

    fun inputPoint(){
        binding.gameTextView.setText("Hello! My name is Jack. And you?")
        binding.inputName.setVisibility(View.VISIBLE)

        binding.choiceButton1.setText("")
        binding.choiceButton2.setText("")
        binding.choiceButton3.setText("Accept")

        binding.choiceButton1.setVisibility(View.INVISIBLE)
        binding.choiceButton2.setVisibility(View.INVISIBLE)

        nextPosition1= ""
        nextPosition2= ""
        nextPosition3= "startingPoint"
    }

    fun startingPoint(){
        val inputEditText = binding.inputName.editText
        val username = inputEditText?.text.toString()

        binding.gameTextView.text = "Great,  $username! What are we going to do?"

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("Walking")
        binding.choiceButton2.setText("Hiking")
        binding.choiceButton3.setText("Go to the field")

        showAllbuttons()

        nextPosition1= "walking"
        nextPosition2= "hiking"
        nextPosition3= "field"
    }
    fun walking(){

        binding.gameView.setImageResource(R.drawable.walking)
        binding.gameTextView.setText("Maybe go home?")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("")
        binding.choiceButton2.setText("Yes, and watch film")
        binding.choiceButton3.setText("Yes, and celebrate the hallowen")

        binding.choiceButton1.setVisibility(View.INVISIBLE)

        nextPosition1= ""
        nextPosition2= "film"
        nextPosition3= "halloween"
    }

    fun hiking(){

        binding.gameView.setImageResource(R.drawable.hiking)
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.gameTextView.setText("How cozy... But it’s already getting dark...")

        binding.choiceButton1.setText("")
        binding.choiceButton2.setText("Go home and watch the film")
        binding.choiceButton3.setText("Go home and celebrate Halloween")

        binding.choiceButton1.setVisibility(View.INVISIBLE)

        nextPosition1= ""
        nextPosition2= "film"
        nextPosition3= "halloween"
    }

    fun field(){

        binding.gameView.setImageResource(R.drawable.field)
        binding.gameTextView.setText("You are sad... Let’s go home?")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("")
        binding.choiceButton2.setText("Maybe, let’s watch the film?")
        binding.choiceButton3.setText("Yes, let’s celebrate the Halloween")

        binding.choiceButton1.setVisibility(View.INVISIBLE)

        nextPosition1= ""
        nextPosition2= "film"
        nextPosition3= "halloween"
    }

    fun film(){

        binding.gameView.setImageResource(R.drawable.film)
        binding.gameTextView.setText("Do you like this film?")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("")
        binding.choiceButton2.setText("I like it!")
        binding.choiceButton3.setText("No...")

        binding.choiceButton1.setVisibility(View.INVISIBLE)

        nextPosition1= ""
        nextPosition2= "likefilm"
        nextPosition3= "dislikefilm"
    }
    fun likefilm(){

        binding.gameView.setImageResource(R.drawable.film)
        binding.gameTextView.setText("Great! It’s time to sleep...")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("Yes, it’s too late...")
        binding.choiceButton2.setText("")
        binding.choiceButton3.setText("")

        binding.choiceButton1.setVisibility(View.VISIBLE)
        binding.choiceButton2.setVisibility(View.INVISIBLE)
        binding.choiceButton3.setVisibility(View.INVISIBLE)

        nextPosition1= "endPoint"
        nextPosition2= ""
        nextPosition3= ""
    }
    fun dislikefilm(){

        binding.gameView.setImageResource(R.drawable.film)
        binding.gameTextView.setText("May be go sleep?")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("Yes, it’s too late...")
        binding.choiceButton2.setText("")
        binding.choiceButton3.setText("")

        binding.choiceButton1.setVisibility(View.VISIBLE)
        binding.choiceButton2.setVisibility(View.INVISIBLE)
        binding.choiceButton3.setVisibility(View.INVISIBLE)

        nextPosition1= "endPoint"
        nextPosition2= ""
        nextPosition3= ""
    }

    fun halloween(){

        binding.gameView.setImageResource(R.drawable.costum)
        binding.gameTextView.setText("Very beautiful!")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("")
        binding.choiceButton2.setText("Yes! Let’s watch the film!")
        binding.choiceButton3.setText("Yes! Let’s create costume!")

        binding.choiceButton1.setVisibility(View.INVISIBLE)

        nextPosition1= ""
        nextPosition2= "film"
        nextPosition3= "costom"
    }
    fun costom(){

        binding.gameView.setImageResource(R.drawable.haloween)
        binding.gameTextView.setText("I like your costume.")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("")
        binding.choiceButton2.setText("Your costume is beautiful too!")
        binding.choiceButton3.setText("To tell you the truth, I don’t like your...")

        binding.choiceButton1.setVisibility(View.INVISIBLE)

        nextPosition1= ""
        nextPosition2= "likecostom"
        nextPosition3= "dislikecostom"
    }
    fun likecostom(){

        binding.gameView.setImageResource(R.drawable.haloween)
        binding.gameTextView.setText("Thank you! Let’s go to sleep.")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("Yes, it’s too late...")
        binding.choiceButton2.setText("")
        binding.choiceButton3.setText("")

        binding.choiceButton1.setVisibility(View.VISIBLE)
        binding.choiceButton2.setVisibility(View.INVISIBLE)
        binding.choiceButton3.setVisibility(View.INVISIBLE)

        nextPosition1= "endPoint"
        nextPosition2= ""
        nextPosition3= ""
    }
    fun dislikecostom(){

        binding.gameView.setImageResource(R.drawable.haloween)
        binding.gameTextView.setText("It’s ok, i’m not taking offence. Let’s go to sleep!")
        binding.gameMC.setVisibility(View.INVISIBLE)

        binding.inputName.setVisibility(View.INVISIBLE)

        binding.choiceButton1.setText("Yes, it’s too late...")
        binding.choiceButton2.setText("")
        binding.choiceButton3.setText("")

        binding.choiceButton1.setVisibility(View.VISIBLE)
        binding.choiceButton2.setVisibility(View.INVISIBLE)
        binding.choiceButton3.setVisibility(View.INVISIBLE)

        nextPosition1= "endPoint"
        nextPosition2= ""
        nextPosition3= ""
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
