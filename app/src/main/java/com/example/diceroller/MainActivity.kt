 package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.Random

 // use this AppCompatActivity to make the app more compatible with more devices.
class MainActivity : AppCompatActivity() {
     // so this lateinit will make it so that we do not need to set the variable to null
     // at the beginning.
     lateinit var diceImage: ImageView
     // always override this abstract method from AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
         val rollButton = findViewById<Button>(R.id.roll_button)
         rollButton.text = getString(R.string.LetsRoll)
         rollButton.setOnClickListener {
             rollDice()
         }
         diceImage = findViewById<ImageView>(R.id.dice_image)
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
         // we want to minimize the number of times we call findViewById because this requires
         // the app to search the view hierarchy for the correct view, which takes time.

         // so best practice is to keep the image in a field, which is a class variable here.
         diceImage.setImageResource(drawableResource)
         /**
          * what is gradle?
            gradle is Android build tool. here are the things gradle does:
            1. describle what devices the app can run on
            2. compile code
            3. dependency management
            4. app signing to download app from Google Play
            5. automated test

          gradle commands compile your source code into an APK (Android Application Package)
          Android Studio transfer the APK to your device or emulator. It installs the APK and runs
          it.

          There are two types of Gradle files:
          1. for project.
          2. for module: app.

          Interesting! The XML file will be compiled into PNG file on phones that are operated
          at the lower API than the minimal support API.
          */
     }
 }