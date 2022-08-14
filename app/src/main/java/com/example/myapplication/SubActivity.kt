package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(applicationContext, "SubActivity onCreate() 호출", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_sub)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "SubActivity onStart() 호출", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext, "SubActivity onRestart() 호출", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "SubActivity onResume() 호출", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "SubActivity onPause() 호출", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "SubActivity onStop() 호출", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "SubActivity onDestroy() 호출", Toast.LENGTH_SHORT).show()
    }
}