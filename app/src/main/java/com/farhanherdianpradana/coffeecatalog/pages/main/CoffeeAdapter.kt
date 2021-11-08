package com.farhanherdianpradana.coffeecatalog.pages.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farhanherdianpradana.coffeecatalog.R
import com.farhanherdianpradana.coffeecatalog.database.CoffeeCatalogDatabaseDao
import com.farhanherdianpradana.coffeecatalog.database.entities.Coffee

class CoffeeAdapter<T: Coffee>(
  var onViewHolderClick: (item: T)->Unit
): RecyclerView.Adapter<CoffeeAdapter.ViewHolder>() {
  class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val root: View = view.findViewById(R.id.root)
    val name: TextView = view.findViewById(R.id.coffeeName)
    val description: TextView = view.findViewById(R.id.coffeeDescription)
    val thumbnail: ImageView = view.findViewById(R.id.coffeeThumbnail)
  }

  var data = listOf<T>()
    set(value) {
      field = value
      notifyDataSetChanged()
    }

  override fun getItemCount() = data.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val item = data[position]

    holder.root.setOnClickListener{
      onViewHolderClick(item)
    }
    holder.name.text = item.name
    holder.description.text = item.description
    holder.thumbnail.setImageResource(item.thumbnailRId)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val layoutInflater = LayoutInflater.from(parent.context)
    val view = layoutInflater.inflate(R.layout.coffee_view_holder, parent, false)
    return ViewHolder(view)
  }
}