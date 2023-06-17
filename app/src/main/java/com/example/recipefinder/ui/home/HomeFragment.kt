package com.example.recipefinder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipefinder.R
import com.example.recipefinder.databinding.FragmentHomeBinding

class HomeFragment: Fragment(){
lateinit var binding: FragmentHomeBinding


private val cuisineAdapter = BrowseCuisinesAdapter()
    private val dietsAdapter = BrowseDietsAdapter()
lateinit var layoutManager: LinearLayoutManager
lateinit var dietLayoutManager: LinearLayoutManager

companion object {
    var locationSelected = ""
}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(
            layoutInflater,
            container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.setTitle("RecipeFinder")
        with(binding) {
          //diet recycler
            dietLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            dietRecyclerView.adapter = dietsAdapter
            dietRecyclerView.layoutManager = dietLayoutManager

            //cuisine recycler
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            cuisineRecyclerView.adapter = cuisineAdapter
            cuisineRecyclerView.layoutManager = layoutManager

            selectIngredientsTextView.setOnClickListener {
                findNavController().navigate(R.id.homeToSheet)
            }
        }

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                locationSelected = "search"

                var queryResult = bundleOf(Pair("query",query))
                findNavController().navigate(R.id.homeToList,queryResult)
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })


    }
}


