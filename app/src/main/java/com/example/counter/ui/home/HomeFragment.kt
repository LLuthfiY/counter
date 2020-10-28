package com.example.counter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.counter.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        setHasOptionsMenu(true);
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val add_button = root.findViewById<Button>(R.id.add_counter)
        val remove_button = root.findViewById<Button>(R.id.remove_counter)



        add_button.setOnClickListener {
            var angka = textView.text.toString().toInt();
            angka += 1
            textView.text = angka.toString()
        }

        remove_button.setOnClickListener {
            var angka = textView.text.toString().toInt();
            angka -= 1
            textView.text = angka.toString()
        }
        return root
    }
}