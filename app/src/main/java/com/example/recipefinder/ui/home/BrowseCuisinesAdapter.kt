package com.example.recipefinder.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.recipefinder.R
import com.example.recipefinder.databinding.BrowseItemsBinding
import com.example.recipefinder.domain.models.Cuisine
import com.example.recipefinder.domain.models.cuisineList
import com.example.recipefinder.domain.repository.cuisineRepository
import com.squareup.picasso.Picasso

class BrowseCuisinesAdapter: RecyclerView.Adapter<BrowseCuisinesAdapter.ViewHolder>() {



    class ViewHolder(val binding: BrowseItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BrowseItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = cuisineList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = cuisineList[position]

        with(holder.binding) {
            cuisineItemTitle.text = currentItem.name
            Picasso.get().load(currentItem.ImageUrl).into(cuisineItemImage)
            root.setOnClickListener {


            var cuisineName = bundleOf(Pair("cuisineName",currentItem.name.toString()))
        HomeFragment.locationSelected = "cuisines"
        holder.itemView.findNavController().navigate(R.id.homeToList,cuisineName)

            }
        }
    }
}


