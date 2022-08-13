package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var getReturnNum: ActivityResultLauncher<Intent>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        val numberText: TextView = findViewById(R.id.number_text)
        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener {
            count++
            numberText.text = count.toString()
        }

        val randomButton: Button = findViewById(R.id.random_button)
        getReturnNum = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK) {
                val returnNum = it.data?.getIntExtra("count", -1)?:""
                count = returnNum.toString().toInt()
                numberText.text = count.toString()
            }
        }

        randomButton.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java).apply {
                putExtra("count", count)
            }
            getReturnNum.launch(intent)
        }
    }
}