package com.example.recipefinder.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.AbsListView.OnScrollListener
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipefinder.R
import com.example.recipefinder.databinding.FragmentListBinding
import com.example.recipefinder.domain.models.cuisineList
import com.example.recipefinder.ui.home.HomeFragment
import kotlinx.coroutines.delay

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    private val args: ListFragmentArgs by navArgs()
    lateinit var layoutManager: LinearLayoutManager
    private val listAdapter = ListAdapter()

companion object{
    var missedIngredients = arrayListOf<String>()
}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(
            layoutInflater,
            container, false
        )

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        println("TEST LIST FRAGMENT")
        println(args.cuisineName)
        println(args.dietName)
        println(args.ingredients)
        println(HomeFragment.locationSelected)
        observeViewModel()

        when (HomeFragment.locationSelected) {

            "cuisines" -> args.cuisineName?.let {
                activity?.setTitle("${args.cuisineName} cuisine")
                viewModel.getCuisineByName(it,10)
            }
            "diets" -> args.dietName?.let {
                activity?.setTitle("${args.dietName} diet")
                viewModel.getDietByName(it)
            }
            "ingredients" -> args.ingredients?.let {
                activity?.setTitle("Browse by Ingredients")
                viewModel.getRecipesByIngredients(args.ingredients.toString())
            }
            "search" -> args.query?.let{
                activity?.setTitle(args.query.toString())
                viewModel.searchByName(it)
            }
        }





        with(binding) {

            layoutManager = LinearLayoutManager(activity)
            listRecyclerView.adapter = listAdapter
            listRecyclerView.layoutManager = layoutManager


        }


    }

    fun observeViewModel() {
        viewModel.recipeLiveData.observe(viewLifecycleOwner) {
            listAdapter.recipeList = it
        }
    }




}