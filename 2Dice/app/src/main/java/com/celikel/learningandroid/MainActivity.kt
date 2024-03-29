    package com.celikel.learningandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button6)

        rollButton.setOnClickListener {
            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            //toast.show()
            //val resultTextView: TextView = findViewById(R.id.textView5)
            //resultTextView.text = "1"
            rollDice()
            rollDice2()
        }
    }

        private fun rollDice() {
            val dice = Dice(6)
            val diceRoll = dice.roll()
            val resultTextView: TextView = findViewById(R.id.textView5)
            resultTextView.text = diceRoll.toString()
        }
        private fun rollDice2() {
            val dice = Dice(6)
            val diceRoll = dice.roll()
            val resultTextView2: TextView = findViewById(R.id.textView6)
            resultTextView2.text = diceRoll.toString()
        }
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }