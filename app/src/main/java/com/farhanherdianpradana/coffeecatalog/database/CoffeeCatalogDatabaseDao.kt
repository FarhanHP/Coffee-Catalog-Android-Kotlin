package com.farhanherdianpradana.coffeecatalog.database

import androidx.room.*
import com.farhanherdianpradana.coffeecatalog.database.entities.FavoriteCoffee

@Dao
interface CoffeeCatalogDatabaseDao {
  @Insert
  suspend fun insertFavoriteCoffee(newCoffee: FavoriteCoffee)

  @Query("SELECT * FROM favoritecoffee")
  suspend fun getAllFavoriteCoffees(): List<FavoriteCoffee>

  @Query("SELECT * FROM favoritecoffee WHERE id=:id")
  suspend fun getFavoriteCoffeeById(id: Int): List<FavoriteCoffee>

  @Delete
  suspend fun deleteFavoriteCoffee(deletedCoffee: FavoriteCoffee)
}