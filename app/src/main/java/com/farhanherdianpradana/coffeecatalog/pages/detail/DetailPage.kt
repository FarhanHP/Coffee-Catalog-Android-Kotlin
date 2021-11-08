package com.farhanherdianpradana.coffeecatalog.pages.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.farhanherdianpradana.coffeecatalog.R
import com.farhanherdianpradana.coffeecatalog.database.CoffeeCatalogDatabase
import com.farhanherdianpradana.coffeecatalog.databinding.FragmentDetailPageBinding

class DetailPage : Fragment() {
  private lateinit var binding: FragmentDetailPageBinding
  private lateinit var viewModelFactory: DetailPageViewModelFactory
  private lateinit var viewModel: DetailPageViewModel
  private lateinit var arguments: DetailPageArgs

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    arguments = DetailPageArgs.fromBundle(requireArguments())
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_page, container, false)
    binding.lifecycleOwner = this
    val application = requireNotNull(this.activity).application
    val databaseDao = CoffeeCatalogDatabase.getInstance(application).coffeeCatalogDatabaseDao
    viewModelFactory = DetailPageViewModelFactory(arguments.coffeeId, databaseDao, application.applicationContext)
    viewModel = ViewModelProvider(this, viewModelFactory).get(DetailPageViewModel::class.java)

    viewModel.coffeePoster.observe(viewLifecycleOwner, Observer {
      binding.coffeePosterImage.setImageResource(it)
    })

    viewModel.coffeeThumbnail.observe(viewLifecycleOwner, Observer {
      binding.coffeeThumbnailImage.setImageResource(it)
    })

    viewModel.isFavorite.observe(viewLifecycleOwner, Observer {
      binding.favoriteBtn.icon = resources.getDrawable(when(it) {
        true -> R.drawable.ic_baseline_favorite_24
        else -> R.drawable.ic_baseline_favorite_border_24
      })
    })

    binding.backBtn.setOnClickListener{
      back()
    }
    binding.detailPageViewModel = viewModel
    return binding.root
  }

  private fun back() {
    activity?.onBackPressed()
  }
}