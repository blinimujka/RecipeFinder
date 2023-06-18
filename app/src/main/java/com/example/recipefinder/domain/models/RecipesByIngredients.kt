package com.example.recipefinder.domain.models
import com.google.gson.annotations.SerializedName
data class RecipesByIngredients(

    @SerializedName("id"                    ) var id                    : Int?                         = null,
    @SerializedName("image"                 ) var image                 : String?                      = null,
    @SerializedName("imageType"             ) var imageType             : String?                      = null,
    @SerializedName("likes"                 ) var likes                 : Int?                         = null,
    @SerializedName("missedIngredientCount" ) var missedIngredientCount : Int?                         = null,
    @SerializedName("missedIngredients"     ) var missedIngredients     : ArrayList<MissedIngredients> = arrayListOf(),
    @SerializedName("title"                 ) var title                 : String?                      = null,
    @SerializedName("unusedIngredients"     ) var unusedIngredients     : ArrayList<String>            = arrayListOf(),
    @SerializedName("usedIngredientCount"   ) var usedIngredientCount   : Int?                         = null,
    @SerializedName("usedIngredients"       ) var usedIngredients       : ArrayList<UsedIngredients>   = arrayListOf()

)

data class MissedIngredients (

    @SerializedName("aisle"        ) var aisle        : String?           = null,
    @SerializedName("amount"       ) var amount       : Float?              = null,
    @SerializedName("id"           ) var id           : Int?              = null,
    @SerializedName("image"        ) var image        : String?           = null,
    @SerializedName("meta"         ) var meta         : ArrayList<String> = arrayListOf(),
    @SerializedName("name"         ) var name         : String?           = null,
    @SerializedName("original"     ) var original     : String?           = null,
    @SerializedName("originalName" ) var originalName : String?           = null,
    @SerializedName("unit"         ) var unit         : String?           = null,
    @SerializedName("unitLong"     ) var unitLong     : String?           = null,
    @SerializedName("unitShort"    ) var unitShort    : String?           = null

)
data class UsedIngredients (

    @SerializedName("aisle"        ) var aisle        : String?           = null,
    @SerializedName("amount"       ) var amount       : Float?              = null,
    @SerializedName("id"           ) var id           : Int?              = null,
    @SerializedName("image"        ) var image        : String?           = null,
    @SerializedName("meta"         ) var meta         : ArrayList<String> = arrayListOf(),
    @SerializedName("name"         ) var name         : String?           = null,
    @SerializedName("original"     ) var original     : String?           = null,
    @SerializedName("originalName" ) var originalName : String?           = null,
    @SerializedName("unit"         ) var unit         : String?           = null,
    @SerializedName("unitLong"     ) var unitLong     : String?           = null,
    @SerializedName("unitShort"    ) var unitShort    : String?           = null

)