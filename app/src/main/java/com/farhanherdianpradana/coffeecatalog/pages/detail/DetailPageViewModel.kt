package com.farhanherdianpradana.coffeecatalog.pages.detail

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhanherdianpradana.coffeecatalog.database.CoffeeCatalogDatabaseDao
import com.farhanherdianpradana.coffeecatalog.database.entities.Coffee
import com.farhanherdianpradana.coffeecatalog.database.entities.FavoriteCoffee
import com.farhanherdianpradana.coffeecatalog.dummies.DummyCoffees
import kotlinx.coroutines.launch

class DetailPageViewModel(
  private val coffeeId: Int, private val databaseDao: CoffeeCatalogDatabaseDao, private val applicationContext: Context
): ViewModel() {
  var coffee = MutableLiveData<Coffee>(DummyCoffees.getCoffeeById(coffeeId))
  var coffeeName: MutableLiveData<String>
  var coffeeDescription: MutableLiveData<String>
  var coffeeThumbnail: MutableLiveData<Int>
  var coffeePoster: MutableLiveData<Int>
  var isFavorite = MutableLiveData<Boolean>(false)

  init {
    coffee.let {
      coffeeName = MutableLiveData(coffee.value?.name)
      coffeeDescription = MutableLiveData(coffee.value?.description)
      coffeeThumbnail = MutableLiveData(coffee.value?.thumbnailRId)
      coffeePoster = MutableLiveData(coffee.value?.posterRId)
    }

    viewModelScope.launch {
      val res = databaseDao.getFavoriteCoffeeById(coffeeId)
      isFavorite.value = res.isNotEmpty()
    }
  }

  fun onFavoriteClick() {
    viewModelScope.launch {
      val favoriteCoffee = FavoriteCoffee(coffeeId, coffeeName.value as String, coffeeDescription.value as String, coffeePoster.value as Int, coffeeThumbnail.value as Int)

      if(isFavorite.value as Boolean) {
        databaseDao.deleteFavoriteCoffee(favoriteCoffee)
        isFavorite.value = false
        Toast.makeText(applicationContext, "Favorite Coffee Removed !", Toast.LENGTH_SHORT).show()
      } else {
        databaseDao.insertFavoriteCoffee(favoriteCoffee)
        isFavorite.value = true
        Toast.makeText(applicationContext, "Favorite Coffee Added !", Toast.LENGTH_SHORT).show()
      }
    }
  }
}