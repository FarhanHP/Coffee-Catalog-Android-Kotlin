package com.farhanherdianpradana.coffeecatalog.pages.detail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.farhanherdianpradana.coffeecatalog.database.CoffeeCatalogDatabaseDao

class DetailPageViewModelFactory(
  private val coffeeId: Int,
  private val databaseDao: CoffeeCatalogDatabaseDao,
  private val applicationContext: Context
): ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(DetailPageViewModel::class.java)) {
      return DetailPageViewModel(coffeeId, databaseDao, applicationContext) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
  }
}