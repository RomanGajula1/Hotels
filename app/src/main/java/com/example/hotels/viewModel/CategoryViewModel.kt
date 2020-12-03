package com.example.hotels.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotels.Adapter.AdapterCategory
import com.example.hotels.Adapter.AdapterHotel
import com.example.hotels.Repository.RepositoryCategory
import com.example.hotels.model.HotelCategories
import org.koin.core.KoinComponent
import org.koin.core.inject

class CategoryViewModel : ViewModel(), KoinComponent {
    val repositoryCategory: RepositoryCategory by inject()
    var id = MutableLiveData("")
    var category = MutableLiveData("")
    val adapterCategories: AdapterCategory = AdapterCategory()
    var listCategory = repositoryCategory.getCategory()

    fun insertCategory(){
        repositoryCategory.insert(HotelCategories(id.value?.toInt(), category.value?.toInt()))
    }
}