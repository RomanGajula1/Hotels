package com.example.hotels.hotel.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.category.repository.RepositoryCategory
import com.example.hotels.city.repository.RepositoryCity
import com.example.hotels.hotel.repository.RepositoryHotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.text.toInt


class UpdateHotelViewModel : ViewModel(), KoinComponent {
    private val repository: RepositoryHotel by inject()
    private val repositoryCategory: RepositoryCategory by inject()
    private val repositoryCity: RepositoryCity by inject()
    val listCity = repositoryCity.getAllCity()
    var listCategory = repositoryCategory.getCategory()

    var name = MutableLiveData("")
    var image = MutableLiveData("")
    var description = MutableLiveData("")
    var category = String()
    var listCategoryToUpdate = repositoryCategory.getHotelWithCategories(category)

    fun getCategory(id: Int){
        repository.getById(id).let {
            category = it.category.toString()
        }
    }

    fun loadForUpdate(id: Int) {
        repository.getById(id).let {
            name.value = it.name
            image.value = it.image
            description.value = it.description
        }
    }

    fun clickUpdateHotel(id: Int, nameCategory: String, nameCity: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val hotel = repository.getById(id)
            hotel.id = id
            hotel.name = name.value
            hotel.image = image.value
            hotel.description = description.value
            hotel.category = nameCategory
            hotel.city = nameCity
            repository.updateHotel(hotel)
        }
    }
}