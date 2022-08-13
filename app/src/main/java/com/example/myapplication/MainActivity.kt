package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toastButton1: Button = findViewById(R.id.toast_button1)
        toastButton1.setOnClickListener {
            showToastMessage1()
        }

        val toastButton2: Button = findViewById(R.id.toast_button2)
        toastButton2.setOnClickListener {
            showToastMessage2()
        }
    }

    private fun showToastMessage1() {
        Toast.makeText(applicationContext, "버튼1 짧게 출력", Toast.LENGTH_SHORT).show()
    }

    private fun showToastMessage2() {
        Toast.makeText(applicationContext, "버튼2 길게 출력", Toast.LENGTH_LONG).show()
    }
}