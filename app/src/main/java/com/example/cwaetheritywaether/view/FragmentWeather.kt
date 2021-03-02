package com.example.cwaetheritywaether.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cwaetheritywaether.R


class FragmentWeather : Fragment() {

    companion object{
        fun newInstance(): FragmentWeather? {
            return FragmentWeather()
        }
    }


    lateinit var today : TextView;
    lateinit var tomorrow : TextView;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)

        today = view.findViewById(R.id.today)
        tomorrow = view.findViewById(R.id.tomorrow)

        return view
    }
}