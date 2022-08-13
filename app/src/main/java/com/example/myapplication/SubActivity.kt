package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val random = Random
        val randomNumText: TextView = findViewById(R.id.random_number_view)
        val intent = Intent(this, MainActivity::class.java).apply {
            val number = intent.getIntExtra("count", -1)
            val randomNum = random.nextInt(number + 1)
            randomNumText.text = randomNum.toString()
            putExtra("count", randomNum)
        }
        setResult(RESULT_OK, intent)
    }
}