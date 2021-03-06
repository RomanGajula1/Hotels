package com.example.hotels.category.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.category.adapter.AdapterCategory
import com.example.hotels.category.repository.RepositoryCategory
import com.example.hotels.category.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class CategoryViewModel : ViewModel(), KoinComponent {
    private val repositoryCategory: RepositoryCategory by inject()
    var id = MutableLiveData("")
    var category = MutableLiveData("")
    val adapterCategories: AdapterCategory = AdapterCategory()
    var listCategory = repositoryCategory.getCategory()

    fun insertCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryCategory.insertCategory(Category(null, category.value))
        }
    }

    fun deleteCategory(category: Category) {
        MainScope().launch() {
            withContext(Dispatchers.IO) {
                repositoryCategory.deleteCategory(category)
            }
        }
    }
}