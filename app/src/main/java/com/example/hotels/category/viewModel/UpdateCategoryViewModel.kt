package com.example.hotels.category.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.category.repository.RepositoryCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class UpdateCategoryViewModel : ViewModel(), KoinComponent {
    private val repositoryCategory: RepositoryCategory by inject()
    var category = MutableLiveData("")

    fun loadForUpdateCategory(id: Int) {
        MainScope().launch() {
            withContext(Dispatchers.IO) {
                repositoryCategory.getById(id).let {
                    category.postValue(it.name.toString())
                }
            }
        }
    }

    fun clickUpdateCategory(id: Int) {
        MainScope().launch() {
            withContext(Dispatchers.IO) {
                val hotelCategory = repositoryCategory.getById(id)
                hotelCategory.name = category.value
                repositoryCategory.updateCategory(hotelCategory)
            }
        }
    }
}