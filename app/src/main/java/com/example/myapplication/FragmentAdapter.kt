package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragment: FragmentActivity): FragmentStateAdapter(fragment) {
    private val color = mutableListOf<Int>()

    override fun getItemCount(): Int = color.size

    override fun createFragment(position: Int): Fragment {
        val colorFragment = ColorFragment()
        val bundle = Bundle()

        bundle.putInt("color", color[position])
        colorFragment.arguments = bundle

        return colorFragment
    }

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