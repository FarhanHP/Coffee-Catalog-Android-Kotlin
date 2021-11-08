package com.farhanherdianpradana.coffeecatalog.dummies

import com.farhanherdianpradana.coffeecatalog.R
import com.farhanherdianpradana.coffeecatalog.database.entities.Coffee

class DummyCoffees {
  companion object {
    val COFFEES = arrayOf(
      Coffee(
        0,
        "Caffe Latte",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus interdum, odio id lacinia interdum, sapien enim tempus metus, vitae venenatis metus tortor consectetur ex.",
        R.drawable.caffe_latte_poster,
        R.drawable.caffe_latte_thumbnail
      ), Coffee(
        1,
        "Caffe Mocha",
        "Aenean vel fermentum felis. Sed varius velit leo, ultricies faucibus lacus tincidunt at. Ut facilisis molestie risus imperdiet mollis. Ut gravida tempus enim, vel rhoncus justo sagittis et",
        R.drawable.caffe_mocha_poster,
        R.drawable.caffe_mocha_thumbnail
      ), Coffee(
        2,
        "Cappucino",
        "ras ac commodo est. Praesent vestibulum enim at lacinia hendrerit. Donec quam eros, accumsan a sem quis, varius rhoncus nisi. Ut tempor tellus eros, in eleifend purus cursus a",
        R.drawable.cappuccino_poster,
        R.drawable.cappuccino_thumbnail
      ), Coffee(
        3,
        "Caramel Macchiato",
        "ras ac commodo est. Praesent vestibulum enim at lacinia hendrerit. Donec quam eros, accumsan a sem quis, varius rhoncus nisi. Ut tempor tellus eros, in eleifend purus cursus a",
        R.drawable.caramel_macchiato_poster,
        R.drawable.caramel_macchiato_thumbnail
      ), Coffee(
        4,
        "Coffee Frappuccino",
        "Aenean vel fermentum felis. Sed varius velit leo, ultricies faucibus lacus tincidunt at. Ut facilisis molestie risus imperdiet mollis. Ut gravida tempus enim, vel rhoncus justo sagittis et",
        R.drawable.coffee_frappuccino_poster,
        R.drawable.coffee_frappuccino_thumbnail
      ), Coffee(
        5,
        "Cold Brew",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        R.drawable.cold_brew_poster,
        R.drawable.cold_brew_thumbnail
      ), Coffee(
        6,
        "Mango Passion Frappuccino",
        "Ut facilisis molestie risus imperdiet mollis. Ut gravida tempus enim, vel rhoncus justo sagittis et",
        R.drawable.mango_passion_frappuccino_poster,
        R.drawable.mango_passion_frappuccino_thumbnail
      ), Coffee(
        7,
        "Mocha Frappuccino",
        "Aenean vel fermentum felis. Sed varius velit leo, ultricies faucibus lacus tincidunt at. Ut facilisis molestie risus imperdiet mollis. Ut gravida tempus enim, vel rhoncus justo sagittis et",
        R.drawable.mocha_frappuccino_poster,
        R.drawable.mocha_frappuccino_thumbnail
      ), Coffee(
        8,
        "Raspberry Currant Frappuccino",
        "Aenean vel fermentum felis. Sed varius velit leo, ultricies faucibus lacus tincidunt at. Ut facilisis molestie risus imperdiet mollis. Ut gravida tempus enim, vel rhoncus justo sagittis et",
        R.drawable.raspberry_currant_frappuccino_poster,
        R.drawable.raspberry_currant_frappuccino_thumbnail
      ), Coffee(
        9,
        "Vanilla Sweet Cream Cold Brew",
        "Aenean vel fermentum felis. Sed varius velit leo, ultricies faucibus lacus tincidunt at. Ut facilisis molestie risus imperdiet mollis. Ut gravida tempus enim, vel rhoncus justo sagittis et",
        R.drawable.vanilla_sweet_cream_cold_brew_poster,
        R.drawable.vanilla_sweet_cream_cold_brew_thumbnail
      )
    )
    fun getCoffeeById(id: Int): Coffee? {
      val filteredCoffee = COFFEES.filter {
        it.id == id
      }

      if(filteredCoffee.isNotEmpty()) {
        return filteredCoffee[0]
      }

      return null
    }
  }
}