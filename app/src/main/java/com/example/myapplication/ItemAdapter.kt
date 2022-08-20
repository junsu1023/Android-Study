package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    private val dataList = mutableListOf<ItemData>()
    private lateinit var onItemClickListener: OnItemClickListener
    private lateinit var onItemLongClickListener: OnItemLongClickListener

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val numberText: TextView = view.findViewById(R.id.number_text)
        val nameTextView: TextView = view.findViewById(R.id.name_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            numberText.text = dataList[position].num.toString()
            nameTextView.text = dataList[position].name

            nameTextView.setOnClickListener {
                onItemClickListener.onItemClick(position)
            }

            nameTextView.setOnLongClickListener {
                onItemLongClickListener.onItemLongClick(position)
                true
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun addData(data: ItemData) {
        dataList.add(data)
        notifyDataSetChanged()
    }

    fun removeData(position: Int) {
        dataList.removeAt(position)
        updateData(position)
        notifyDataSetChanged()
    }

    fun reviseData(data: ItemData, position: Int) {
        dataList[position] = data
        notifyDataSetChanged()
    }

    private fun updateData(position: Int) {
        for(i in position until dataList.size) {
            val num = dataList[i].num
            val name = dataList[i].name
            dataList[i] = ItemData(num-1, name)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(position: Int)
    }

    fun setOnItemClickListener(onItemClick: (Int) -> Unit) {
        onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                onItemClick(position)
            }
        }
    }

    fun setOnItemLongClickListener(onItemLongClick: (Int) -> Unit) {
        onItemLongClickListener = object : OnItemLongClickListener {
            override fun onItemLongClick(position: Int) {
                onItemLongClick(position)
            }
        }
    }
}