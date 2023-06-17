package com.example.recipefinder.domain.repository

import com.example.recipefinder.data.ApiService
import com.example.recipefinder.domain.models.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class cuisineRepository {
    private val api: ApiService
    private val apiKey = "6f037641978247f0a513d1544165daf8"
    var number = 10

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiService::class.java)
    }
    suspend fun getCuisineByName(cuisineName:String,number:Int): RecipesResponse {
        return api.getCuisineByName(cuisineName,number,apiKey)
    }
    suspend fun getDietByName(dietName:String): RecipesResponse {
        return api.getDietByName(dietName,number,apiKey)
    }
    suspend fun getRecipesByIngredients(ingredients:String): List<RecipesByIngredients> {
        println(ingredients.toString())
        return api.getRecipesByIngredients(ingredients,number,apiKey)
    }
    suspend fun getRecipeById(id:String): DetailedRecipe{
        return api.getRecipeById(id,apiKey)
    }
    suspend fun getSimilarById(id:String): List<SimilarRecipes> {
        return api.getSimilarById(id,apiKey)
    }
    suspend fun searchByName(query:String): RecipesResponse{
        return api.searchByName(query, apiKey)
    }
}

