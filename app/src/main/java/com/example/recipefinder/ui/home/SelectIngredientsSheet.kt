package com.example.recipefinder.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.recipefinder.R
import com.example.recipefinder.databinding.BottomsheetSelectIngredientsBinding
import com.example.recipefinder.databinding.ItemSelectIngridientsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SelectIngredientsSheet : BottomSheetDialogFragment() {

    lateinit var binding: BottomsheetSelectIngredientsBinding
    var myIngredientsList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomsheetSelectIngredientsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.doneBttn.setOnClickListener {
            HomeFragment.locationSelected = "ingredients"
           var bundle = bundleOf(Pair("ingredients",myIngredientsList.toString()))
            findNavController().navigate(R.id.sheetToList,bundle)
        }
        setupIngredients()

    }
    private fun setupIngredients() {
        var ingredientsArray = arrayOf("salt",
            "olive oil",
            "butter",
            "sugar",
            "water",
            "flour",
            "garlic",
            "eggs",
            "onion",
            "vanilla extract",
            "milk",
            "kosher salt",
            "lemon juice",
            "unsalted butter",
            "black pepper")



        for (ingredient in ingredientsArray) {

            val itemBinding =
                ItemSelectIngridientsBinding.inflate(layoutInflater, binding.root, false)
            itemBinding.ingredientName.text = ingredient
            itemBinding.root.setOnClickListener {
                with(itemBinding.checkbox) {
                    isSelected = !isSelected

                    when (isSelected) {
                        true -> {
                            myIngredientsList.add(itemBinding.ingredientName.text as String)
                            setImageResource(R.mipmap.ic_serving_filled)
                        }
                        false -> {
                            myIngredientsList.remove(itemBinding.ingredientName.text as String)
                            setImageResource(R.mipmap.ic_ingredient_foreground)
                        }
                        }
                }
            }
            binding.ingredientsHolder.addView(itemBinding.root)
        }
    }

}
