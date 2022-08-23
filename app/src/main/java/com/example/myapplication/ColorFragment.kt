package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ColorFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_color, container, false)
        val colorView: View = rootView.findViewById(R.id.color_view)
        val color = requireArguments().getInt("color")
        colorView.setBackgroundColor(color)

        return rootView
    }
}