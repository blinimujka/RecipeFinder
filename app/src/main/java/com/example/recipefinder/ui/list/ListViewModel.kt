package com.example.recipefinder.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipefinder.domain.models.DetailedRecipe
import com.example.recipefinder.domain.models.Recipe
import com.example.recipefinder.domain.models.RecipesByIngredients
import com.example.recipefinder.domain.models.RecipesResponse
import com.example.recipefinder.domain.repository.cuisineRepository
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private val repo = cuisineRepository()
    val recipeLiveData = MutableLiveData<List<Recipe>>()
    private var recipeList = ArrayList<Recipe>()


    fun getCuisineByName(cuisineName: String,number:Int) {
        viewModelScope.launch {
            recipeList.addAll(repo.getCuisineByName(cuisineName,number).results)

            recipeLiveData.value = recipeList

        }
    }

    fun getDietByName(dietName: String) {
        viewModelScope.launch {
            recipeList.addAll(repo.getDietByName(dietName).results)

            recipeLiveData.value = recipeList

        }
    }
    fun getRecipesByIngredients(ingredients: String) {
        viewModelScope.launch {
            val array = repo.getRecipesByIngredients(ingredients)

            array.forEachIndexed { index, item ->
                var recipeObj = Recipe(item.id, item.title, item.image, item.imageType)
                recipeList.add(recipeObj)

                var missedIngredientsString =""

                item.missedIngredients.forEach { recipe ->

                    missedIngredientsString +="${recipe.name}, "

                    }
                ListFragment.missedIngredients.add(missedIngredientsString.dropLast(2))
                println(missedIngredientsString)
                missedIngredientsString= "" //reset string for next iteration
println(ListFragment.missedIngredients)
                }

            recipeLiveData.value = recipeList

        }




        }
    fun searchByName(query: String){
        viewModelScope.launch {
            recipeList.addAll(repo.searchByName(query).results)
            recipeLiveData.value = recipeList
        }
    }
    }
