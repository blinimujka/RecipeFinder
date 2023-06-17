package com.example.recipefinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipefinder.databinding.FragmentHomeBinding
import com.example.recipefinder.domain.models.cuisineList
import com.example.recipefinder.ui.home.BrowseCuisinesAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}