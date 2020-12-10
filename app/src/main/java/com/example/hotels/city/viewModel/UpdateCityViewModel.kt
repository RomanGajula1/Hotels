package com.example.hotels.city.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.city.repository.RepositoryCity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class UpdateCityViewModel : ViewModel(), KoinComponent {
    private val repositoryCity: RepositoryCity by inject()
    var city = MutableLiveData("")

    fun loadForUpdateCity(id: Int) {
        repositoryCity.getById(id).let {
            city.value = it.city.toString()
        }
    }

    fun clickUpdateCity(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val hotelCity = repositoryCity.getById(id)
            hotelCity.city = city.value
            repositoryCity.updateCity(hotelCity)
        }
    }
}