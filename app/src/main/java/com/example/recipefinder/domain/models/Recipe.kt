package com.example.recipefinder.domain.models
import com.google.gson.annotations.SerializedName
data class Recipe (

    @SerializedName("id"        ) var id        : Int?    = null,
    @SerializedName("title"     ) var title     : String? = null,
    @SerializedName("image"     ) var image     : String? = null,
    @SerializedName("imageType" ) var imageType : String? = null
)
data class RecipesResponse (

    @SerializedName("results" ) var results : ArrayList<Recipe> = arrayListOf()
)


data class SimilarRecipes (

    @SerializedName("id"             ) var id             : Int?    = null,
    @SerializedName("title"          ) var title          : String? = null,
    @SerializedName("imageType"      ) var imageType      : String? = null,
    @SerializedName("readyInMinutes" ) var readyInMinutes : Int?    = null,
    @SerializedName("servings"       ) var servings       : Int?    = null,
    @SerializedName("sourceUrl"      ) var sourceUrl      : String? = null
)
data class SimilarRecipesResponse (

    @SerializedName("results" ) var results : ArrayList<SimilarRecipes> = arrayListOf()
)
