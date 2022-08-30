package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random

class ChangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        val count = intent.getIntExtra("count", 0)
        val receiveNumTextView: TextView = findViewById(R.id.receive_number_text_view)

        val randomNuｍ = Random.nextInt(count)
        receiveNumTextView.text = randomNuｍ.toString()
    }
}