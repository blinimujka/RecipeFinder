package com.example.recipefinder.ui.list

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recipefinder.R
import com.example.recipefinder.databinding.BrowseItemsBinding
import com.example.recipefinder.databinding.ListItemRecipeBinding
import com.example.recipefinder.domain.models.Recipe
import com.example.recipefinder.ui.home.HomeFragment
import com.squareup.picasso.Picasso

class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var recipeList: List<Recipe> = emptyList()

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(val binding: ListItemRecipeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        val binding = ListItemRecipeBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = recipeList.size

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        val currentRecipe = recipeList[position]

        with(holder.binding){
            recipeName.text = currentRecipe.title
            Picasso.get().load(currentRecipe.image).into(recipeImage)

            if(HomeFragment.locationSelected=="ingredients") {
                missingIngredients.text = ListFragment.missedIngredients[position]
                missingIcon.setImageResource(R.mipmap.ic_missing_foreground)
            }
                root.setOnClickListener{
                    println(currentRecipe.id)
                    println(currentRecipe.id.toString())
                    var recipeID = bundleOf(Pair("recipeID",currentRecipe.id.toString()))
                    holder.itemView.findNavController().navigate(R.id.listToDetail,recipeID)
                }
            }


        }


    }
