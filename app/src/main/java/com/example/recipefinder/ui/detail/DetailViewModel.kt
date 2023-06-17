package com.example.recipefinder.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipefinder.domain.models.DetailedRecipe
import com.example.recipefinder.domain.models.SimilarRecipes
import com.example.recipefinder.domain.models.SimilarRecipesResponse
import com.example.recipefinder.domain.repository.cuisineRepository
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val repo = cuisineRepository()
    var detailedRecipeData = MutableLiveData<DetailedRecipe>()
    var similarRecipeLiveData = MutableLiveData<List<SimilarRecipes>>()
    var similarRecipeList = ArrayList<SimilarRecipes>()

     fun getRecipeById(recipe_id:String) {
         viewModelScope.launch {
             detailedRecipeData.value = repo.getRecipeById(recipe_id)


         }
    }
    fun getSimilarById(recipe_id:String) {
        viewModelScope.launch {
            similarRecipeList.addAll(repo.getSimilarById(recipe_id))
            similarRecipeLiveData.value = similarRecipeList

        }
    }
//     fun getDietByName(dietName: String) {
//        viewModelScope.launch {
//            recipeList.addAll(repo.getDietByName(dietName).results)
//            println("testDIet")
//            recipeLiveData.value = recipeList
//
//        }
//    }

}