package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA: Fragment = AFragment()
        val fragmentB: Fragment = BFragment()

        val aFragmentButton: Button = findViewById(R.id.fragmentA_button)
        val bFragmentBButton: Button = findViewById(R.id.fragmentB_button)

        aFragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragmentA).commit()
        }

        bFragmentBButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragmentB).commit()
        }
    }
}