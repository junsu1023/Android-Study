package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var numberTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
        }

        setContentView(R.layout.activity_main)

        numberTextView = findViewById(R.id.number_text)
        val countButton: Button = findViewById(R.id.count_button)
        val dialogButton: Button = findViewById(R.id.dialog_button)

        countButton.setOnClickListener {
            count++
            numberTextView.text = count.toString()
        }

        dialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.apply {
                setTitle(R.string.dialog).setMessage(R.string.select_option)
                    .setPositiveButton(R.string.initialization) { _, _ ->
                        count = 0
                        numberTextView.text = count.toString() }
                    .setNeutralButton(R.string.toast) { _, _ ->
                        Toast.makeText(context, R.string.notice, Toast.LENGTH_SHORT).show() }
                    .setNegativeButton(R.string.none) { dialog, _ ->
                        dialog.dismiss() }
            }.show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        numberTextView.text = savedInstanceState.getInt("count").toString()
    }
}

