package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val inputNameText: EditText = findViewById(R.id.input_name_text)
        val addButton: ImageButton = findViewById(R.id.add_button)
        val itemAdapter = ItemAdapter()
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter
            addItemDecoration(decoration)
        }

        addButton.setOnClickListener {
            if(inputNameText.text.toString() != "") {
                itemAdapter.addData(ItemData((idx + 1), inputNameText.text.toString()))
                inputNameText.setText("")
                idx++
            }
        }

        itemAdapter.setOnItemClickListener {
            val dialog = AlertDialog.Builder(this)
            val reviseView = layoutInflater.inflate(R.layout.revise_name, null)

            dialog.apply {
                setMessage(R.string.revise)
                setView(reviseView)
                setPositiveButton(R.string.yes) { _, _ ->
                    val reviseNameText: EditText = reviseView.findViewById(R.id.revise_name_text)
                    itemAdapter.reviseData(ItemData(it + 1, reviseNameText.text.toString()), it)
                }
                setNegativeButton(R.string.no) { dialog, _ ->
                    dialog.dismiss()
                }
            }.show()
        }

        itemAdapter.setOnItemLongClickListener {
            val dialog = AlertDialog.Builder(this)

            dialog.apply {
                setMessage(R.string.remove)
                setPositiveButton(R.string.yes) { _, _ ->
                    itemAdapter.removeData(it)
                    idx--
                }
                setNegativeButton(R.string.no) { dialog, _ ->
                    dialog.dismiss()
                }
            }.show()
        }
    }
}