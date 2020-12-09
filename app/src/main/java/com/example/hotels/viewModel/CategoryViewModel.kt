package com.example.hotels.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.Adapter.AdapterCategory
import com.example.hotels.Repository.RepositoryCategory
import com.example.hotels.model.HotelCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class CategoryViewModel : ViewModel(), KoinComponent {
    val repositoryCategory: RepositoryCategory by inject()
    var id = MutableLiveData("")
    var category = MutableLiveData("")
    val adapterCategories: AdapterCategory = AdapterCategory()
    var listCategory = repositoryCategory.getCategory()

    fun insertCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryCategory.insertCategory(HotelCategories(null, category.value?.toInt()))
        }
    }
}