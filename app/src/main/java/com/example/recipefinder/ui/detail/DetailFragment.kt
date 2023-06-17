package com.example.recipefinder.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recipefinder.databinding.FragmentDetailBinding
import com.example.recipefinder.databinding.FragmentListBinding
import com.example.recipefinder.databinding.ItemSelectIngridientsBinding
import com.example.recipefinder.databinding.RecipeIngredientItemBinding
import com.squareup.picasso.Picasso


class DetailFragment:Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    lateinit var binding: FragmentDetailBinding
    val detailViewModel: DetailViewModel by viewModels()
    lateinit var detailLayout : LinearLayoutManager
    private var similarAdapter = SimilarRecipesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(
            layoutInflater,
            container, false
        )

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = args.recipeID

        if (id != null) {
            detailViewModel.getRecipeById(id)
            detailViewModel.getSimilarById(id)
            observeViewModel()



        }
        with(binding) {
            detailLayout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            binding.similarRecipesRecyclerView.adapter = similarAdapter
            binding.similarRecipesRecyclerView.layoutManager = detailLayout
        }

    }

    fun observeViewModel() {
        detailViewModel.detailedRecipeData.observe(viewLifecycleOwner) {
            activity?.setTitle(it.title)

            Picasso.get().load(it.image).into(binding.imageView)
            binding.summaryTextView.text = it.summary
            binding.readyInMinutesTextView.text =
                ("Ready in ${it.readyInMinutes.toString()} minutes")
            binding.likeCount.text = it.aggregateLikes.toString()



            for (ingredient in it.extendedIngredients) {

                var ingredientItemBinding =
                    RecipeIngredientItemBinding.inflate(layoutInflater, binding.root, false)
                ingredientItemBinding.ingredientName.text = ingredient.original
                binding.ingredientsHolder.addView(ingredientItemBinding.root)
            }

        }
        detailViewModel.similarRecipeLiveData.observe(viewLifecycleOwner){
            similarAdapter.similarRecipesList = it
        }

    }
}