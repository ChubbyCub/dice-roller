 package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
         val drawableResource = when (Random().nextInt(6) + 1) {
             1 -> R.drawable.dice_1
             2 -> R.drawable.dice_2
             3 -> R.drawable.dice_3
             4 -> R.drawable.dice_4
             5 -> R.drawable.dice_5
             else -> R.drawable.dice_6
         }
         val diceImage: ImageView = findViewById<ImageView>(R.id.dice_image)
         diceImage.setImageResource(drawableResource)
     }
 }