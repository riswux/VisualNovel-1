package com.example.labwork1

import com.google.gson.Gson
import java.io.File


data class Scenario(
    val text: String,
    val choice1: String,
    val choice2: String,
    val choice3: String,
    val nextPosition1: String,
    val nextPosition2: String,
    val nextPosition3: String
)

fun main() {
    val scenarios = listOf(
        Scenario(
            "Hello! My name is Jack. And you?",
            "",
            "",
            "Accept",
            "",
            "",
            "startingPoint"
        ),
        Scenario(
            "Great, [username]! What are we going to do?",
            "Walking",
            "Hiking",
            "Go to the field",
            "walking",
            "hiking",
            "field"
        ),
        Scenario(
            "Maybe go home?",
            "",
            "Yes, and watch film",
            "Yes, and celebrate the halloween",
            "",
            "film",
            "halloween"
        ),
        // add more scenarios here...
    )
    // Convert scenarios to JSON format
    val gson = Gson()
    val json = gson.toJson(scenarios)

    // Save JSON to file
    val file = File("scenarios.json")
    file.writeText(json)
}

