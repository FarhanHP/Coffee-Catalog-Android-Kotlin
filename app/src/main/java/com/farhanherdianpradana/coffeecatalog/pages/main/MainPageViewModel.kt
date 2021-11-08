package com.farhanherdianpradana.coffeecatalog.pages.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhanherdianpradana.coffeecatalog.database.CoffeeCatalogDatabaseDao
import com.farhanherdianpradana.coffeecatalog.database.entities.Coffee
import com.farhanherdianpradana.coffeecatalog.database.entities.FavoriteCoffee
import kotlinx.coroutines.launch

const val COFFEE_CATALOG = "Coffee Catalog"
const val ALL_COFFEE = "$COFFEE_CATALOG - All Coffee"
const val FAVORITE_COFFEE = "$COFFEE_CATALOG - Favorite Coffee"

class MainPageViewModel(
  coffees: Array<Coffee>, private val databaseDao: CoffeeCatalogDatabaseDao
): ViewModel() {
  private var favoriteCoffee: List<FavoriteCoffee> = listOf()
  private val coffeesList = coffees.toList()
  val coffeesLiveData = MutableLiveData<List<Coffee>>(coffeesList)
  val title = MutableLiveData<String>(ALL_COFFEE)

  fun onVisitFavoriteCoffee() {
    viewModelScope.launch {
      favoriteCoffee = databaseDao.getAllFavoriteCoffees()
      title.value = FAVORITE_COFFEE
      coffeesLiveData.value = favoriteCoffee.map {
        Coffee(it.id, it.name, it.description, it.posterRId, it.thumbnailRId)
      }
    }
  }

  fun onVisitAllCoffee() {
    title.value = ALL_COFFEE
    coffeesLiveData.value = coffeesList
  }
}