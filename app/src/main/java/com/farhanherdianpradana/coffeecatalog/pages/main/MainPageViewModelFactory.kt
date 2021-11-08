package com.farhanherdianpradana.coffeecatalog.pages.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farhanherdianpradana.coffeecatalog.database.CoffeeCatalogDatabaseDao
import com.farhanherdianpradana.coffeecatalog.database.entities.Coffee

class MainPageViewModelFactory(
  private val coffees: Array<Coffee>,
  private val databaseDao: CoffeeCatalogDatabaseDao
) : ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MainPageViewModel::class.java)) {
      return MainPageViewModel(coffees, databaseDao) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}