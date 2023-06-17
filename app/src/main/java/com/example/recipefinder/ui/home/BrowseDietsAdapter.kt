package com.example.recipefinder.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.recipefinder.R
import com.example.recipefinder.databinding.BrowseItemsBinding
import com.example.recipefinder.domain.models.dietsList
import com.squareup.picasso.Picasso


class BrowseDietsAdapter : RecyclerView.Adapter<BrowseDietsAdapter.ViewHolder>() {


    class ViewHolder(val binding: BrowseItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BrowseItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = dietsList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dietsList[position]

        with(holder.binding) {
            cuisineItemTitle.text = currentItem.name
            Picasso.get().load(currentItem.ImageUrl).into(cuisineItemImage)

            root.setOnClickListener {

                HomeFragment.locationSelected = "diets"
                var dietName = bundleOf(Pair("dietName", currentItem.name.toString()))
                holder.itemView.findNavController().navigate(R.id.homeToList,dietName)
            }
        }
    }
}


