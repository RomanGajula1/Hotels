package com.example.hotels.hotel.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.category.repository.RepositoryCategory
import com.example.hotels.city.repository.RepositoryCity
import com.example.hotels.hotel.repository.RepositoryHotel
import com.example.hotels.hotel.model.Hotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class AddHotelViewModel : ViewModel(), KoinComponent {
    val name = MutableLiveData("")
    val image = MutableLiveData("")
    val description = MutableLiveData("")
    private val repository: RepositoryHotel by inject()
    private val repositoryCategory: RepositoryCategory by inject()
    private val repositoryCity: RepositoryCity by inject()
    val listCity = repositoryCity.getAllCity()
    var listCategory = repositoryCategory.getCategory()

    fun clickAddHotel(nameCategory: String, nameCity: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHotel(
                Hotel(
                    null,
                    name.value.toString(),
                    image.value.toString(),
                    description.value.toString(),
                    nameCategory,
                    nameCity
                )
            )
        }
    }
}