package com.example.diceroller

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        val numSides: EditText = findViewById(R.id.editTextNumSides)
        val numThrows: EditText = findViewById(R.id.editTextNumThrows)
        val resultList: ListView = findViewById(R.id.resultList)

        rollButton.setOnClickListener {

            val dicesList = mutableListOf<String>()

            repeat(numThrows.text.toString().toInt()) {
                dicesList.add(rollDice(numSides.text.toString().toInt()).toString())
            }

            val arrayAdapter: ArrayAdapter<String> =
                ArrayAdapter<String>(this, R.layout.simple_list_item_custom, dicesList)
            resultList.adapter = arrayAdapter
        }
    }


    private fun rollDice(numberOfSides: Int): Int {
        val dice = Dice(numberOfSides)
        return dice.roll()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}