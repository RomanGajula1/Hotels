package com.example.hotels.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotels.Adapter.AdapterCity
import com.example.hotels.Repository.RepositoryCity
import com.example.hotels.model.HotelCity
import org.koin.core.KoinComponent
import org.koin.core.inject

class CityViewModel : ViewModel(), KoinComponent {
    val repositoryCity: RepositoryCity by inject()
    var city = MutableLiveData("")
    var listCity = repositoryCity.getAllCity()
    val adapterCity = AdapterCity()

    fun insertCity() {
        repositoryCity.insertCity(HotelCity(null, city.value))
    }
}