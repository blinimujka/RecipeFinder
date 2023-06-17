package com.example.recipefinder.ui.detail


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recipefinder.R
import com.example.recipefinder.databinding.BrowseItemsBinding
import com.example.recipefinder.databinding.SimilarRecipesBinding
import com.example.recipefinder.domain.models.Recipe
import com.example.recipefinder.domain.models.SimilarRecipes
import com.example.recipefinder.domain.models.SimilarRecipesResponse
import com.squareup.picasso.Picasso


class SimilarRecipesAdapter: RecyclerView.Adapter<SimilarRecipesAdapter.ViewHolder>() {
    var similarRecipesList: List<SimilarRecipes> = emptyList()

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(val binding: SimilarRecipesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarRecipesAdapter.ViewHolder {
        val binding = SimilarRecipesBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = similarRecipesList.size

    override fun onBindViewHolder(holder: SimilarRecipesAdapter.ViewHolder, position: Int) {

        println("test1")
        println(similarRecipesList)
        val currentRecipe = similarRecipesList[position]

        with(holder.binding){
            recipeTitle.text = currentRecipe.title
            rdyInMins.text = "${currentRecipe.readyInMinutes}"
            servings.text = currentRecipe.servings.toString()
            Picasso.get().load(currentRecipe.sourceUrl).into(recipeImage)


            root.setOnClickListener{
                println(currentRecipe.id)
                println(currentRecipe.id.toString())
                var recipeID = bundleOf(Pair("recipeID",currentRecipe.id.toString()))
                holder.itemView.findNavController().navigate(R.id.detailToDetail,recipeID)
            }
        }

        }
    }





