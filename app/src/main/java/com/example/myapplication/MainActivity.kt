package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.main_view, HomeFragment()).commit()

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation_view)

        bottomNavigation.run {
            setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.bottom_home -> {
                        supportFragmentManager.beginTransaction().replace(R.id.main_view, HomeFragment()).commit()
                        true
                    }
                    R.id.bottom_user -> {
                        supportFragmentManager.beginTransaction().replace(R.id.main_view, UserFragment()).commit()
                        true
                    }
                    R.id.bottom_setting -> {
                        supportFragmentManager.beginTransaction().replace(R.id.main_view, SettingFragment()).commit()
                        true
                    }
                    else -> false
                }
            }
        }
    }
}