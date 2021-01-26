 package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Random

 // use this AppCompatActivity to make the app more compatible with more devices.
class MainActivity : AppCompatActivity() {
     // always override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val rollButton = findViewById<Button>(R.id.roll_button)
         rollButton.text = getString(R.string.LetsRoll)
         rollButton.setOnClickListener {
             rollDice()
         }
    }

     private fun rollDice() {
         val resultText: TextView = findViewById<TextView>(R.id.result_text)
         val randomInt = Random().nextInt(6) + 1
         resultText.text = randomInt.toString()
     }
 }