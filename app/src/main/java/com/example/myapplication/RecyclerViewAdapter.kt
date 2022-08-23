package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val color = mutableListOf<Int>()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val colorLayout: View = view.findViewById(R.id.color_layout)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_color, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            colorLayout.background = color[position].toDrawable()
        }
    }

    override fun getItemCount(): Int = color.size

    fun addColor() {
        color.add(Color.parseColor("#FF0000"))
        color.add(Color.parseColor("#FFA500"))
        color.add(Color.parseColor("#FFFF00"))
        color.add(Color.parseColor("#008000"))
        color.add(Color.parseColor("#0000FF"))
        color.add(Color.parseColor("#4B0082"))
        color.add(Color.parseColor("#800080"))
        notifyDataSetChanged()
    }
}