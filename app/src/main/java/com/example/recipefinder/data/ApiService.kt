package com.example.recipefinder.data

import com.example.recipefinder.domain.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("recipes/complexSearch")
    suspend fun getCuisineByName(@Query("cuisine") cuisine_name: String,
                                 @Query("number") numberOfRecipes : Int,
                                 @Query("apiKey") apiKey : String
   ): RecipesResponse

    @GET("recipes/complexSearch")
    suspend fun getDietByName(@Query("diet") diet: String,
                              @Query("number") numberOfRecipes: Int,
                              @Query("apiKey") apiKey: String
                              ): RecipesResponse


    @GET("recipes/findByIngredients")
    suspend fun getRecipesByIngredients(@Query("ingredients") ingredients : String,
                                        @Query("number")number: Int,
                                        @Query("apiKey") apiKey: String
                                        ) : List<RecipesByIngredients>



    @GET("recipes/{recipe_id}/information")
    suspend fun getRecipeById(@Path("recipe_id") recipe_id: String,
                              @Query("apiKey") apiKey: String) : DetailedRecipe

    @GET("recipes/{recipe_id}/similar")
    suspend fun getSimilarById(@Path("recipe_id") recipe_id:String,
                                @Query("apiKey") apiKey: String): List<SimilarRecipes>


//https://api.spoonacular.com/recipes/complexSearch?query=chicken&apiKey=1b21366a928140af8745dbeda7538cd0
    @GET("recipes/complexSearch")
    suspend fun searchByName(@Query("query") query:String,
                            @Query("apiKey") apiKey:String): RecipesResponse
}
