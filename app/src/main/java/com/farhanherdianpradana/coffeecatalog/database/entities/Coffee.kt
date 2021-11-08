package com.farhanherdianpradana.coffeecatalog.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Coffee(
  @PrimaryKey val id: Int,
  @ColumnInfo(name="name") val name: String,
  @ColumnInfo(name="description") val description: String,
  @ColumnInfo(name="poster_r_id") val posterRId: Int,
  @ColumnInfo(name="thumbnail_r_id") val thumbnailRId: Int,
)
