package com.example.hotels.city.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.city.adapter.AdapterCity
import com.example.hotels.city.repository.RepositoryCity
import com.example.hotels.city.model.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class CityViewModel : ViewModel(), KoinComponent {
    private val repositoryCity: RepositoryCity by inject()
    var city = MutableLiveData("")
    var listCity = repositoryCity.getAllCity()
    val adapterCity = AdapterCity()

    fun insertCity() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryCity.insertCity(City(null, city.value))
        }
    }

    fun deleteCity(city: City) {
        MainScope().launch() {
            withContext(Dispatchers.IO) {
                repositoryCity.deleteCity(city)
            }
        }
    }
}