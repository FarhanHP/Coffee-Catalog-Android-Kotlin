package com.farhanherdianpradana.coffeecatalog.pages.main

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.farhanherdianpradana.coffeecatalog.R
import com.farhanherdianpradana.coffeecatalog.database.CoffeeCatalogDatabase
import com.farhanherdianpradana.coffeecatalog.database.entities.Coffee
import com.farhanherdianpradana.coffeecatalog.database.entities.FavoriteCoffee
import com.farhanherdianpradana.coffeecatalog.databinding.FragmentMainPageBinding
import com.farhanherdianpradana.coffeecatalog.dummies.DummyCoffees

class MainPage : Fragment() {
  private lateinit var mainPageViewModel: MainPageViewModel
  private lateinit var application: Application
  private lateinit var mainPageViewModelFactory: MainPageViewModelFactory
  private lateinit var binding: FragmentMainPageBinding
  private lateinit var coffeeAdapter: CoffeeAdapter<Coffee>

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false)
    binding.lifecycleOwner = this
    application = requireNotNull(this.activity).application
    val databaseDao = CoffeeCatalogDatabase.getInstance(application).coffeeCatalogDatabaseDao
    mainPageViewModelFactory = MainPageViewModelFactory(DummyCoffees.COFFEES, databaseDao)
    mainPageViewModel = ViewModelProvider(this, mainPageViewModelFactory).get(MainPageViewModel::class.java)
    binding.mainPageViewModel = mainPageViewModel

    coffeeAdapter = CoffeeAdapter{
      handleShowDetail(it.id)
    }
    mainPageViewModel.coffeesLiveData.observe(viewLifecycleOwner, Observer {
      coffeeAdapter.data = it
    })
    binding.cofeeList.adapter = coffeeAdapter

    return binding.root
  }

  // a desperate attempt to update favorite coffee list when user unfavorite it
  override fun onResume() {
    super.onResume()

    mainPageViewModel.onVisitAllCoffee()
  }

  private fun handleShowDetail(coffeeId: Int) {
    findNavController().navigate(MainPageDirections.actionMainPageToDetailPage(coffeeId))
  }
}