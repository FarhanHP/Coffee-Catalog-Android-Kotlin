package com.farhanherdianpradana.coffeecatalog.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.farhanherdianpradana.coffeecatalog.database.entities.Coffee
import com.farhanherdianpradana.coffeecatalog.database.entities.FavoriteCoffee

@Database(entities = [Coffee::class, FavoriteCoffee::class], version = 1, exportSchema = false)
abstract class CoffeeCatalogDatabase: RoomDatabase() {
  abstract val coffeeCatalogDatabaseDao: CoffeeCatalogDatabaseDao

  companion object {
    @Volatile
    private var INSTANCE: CoffeeCatalogDatabase? = null

    fun getInstance(context: Context): CoffeeCatalogDatabase {
      synchronized(this) {
        var instance = INSTANCE

        if(instance == null) {
          instance = Room.databaseBuilder(context.applicationContext, CoffeeCatalogDatabase::class.java, "coffee_catalog_database").fallbackToDestructiveMigration().build()
          INSTANCE = instance
        }

        return instance
      }
    }
  }
}