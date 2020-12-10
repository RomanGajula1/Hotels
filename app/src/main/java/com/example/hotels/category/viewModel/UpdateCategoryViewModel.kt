package com.example.hotels.category.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.category.repository.RepositoryCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class UpdateCategoryViewModel : ViewModel(), KoinComponent {
    private val repositoryCategory: RepositoryCategory by inject()
    var category = MutableLiveData("")

    fun loadForUpdateCategory(id: Int) {
        repositoryCategory.getById(id).let {
            category.value = it.category.toString()
        }
    }

    fun clickUpdateCategory(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val hotelCategory = repositoryCategory.getById(id)
            hotelCategory.category = category.value?.toInt()
            repositoryCategory.updateCategory(hotelCategory)
        }
    }
}