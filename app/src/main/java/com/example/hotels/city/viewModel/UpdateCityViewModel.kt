package com.example.hotels.city.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotels.city.repository.RepositoryCity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class UpdateCityViewModel : ViewModel(), KoinComponent {
    private val repositoryCity: RepositoryCity by inject()
    var city = MutableLiveData("")

    fun loadForUpdateCity(id: Int) {
        MainScope().launch {
            withContext(Dispatchers.IO) {
                repositoryCity.getById(id).let {
                    city.postValue(it.name.toString())
                }
            }
        }
    }

    fun clickUpdateCity(id: Int) {
        MainScope().launch {
            withContext(Dispatchers.IO) {
                val hotelCity = repositoryCity.getById(id)
                hotelCity.name = city.value
                repositoryCity.updateCity(hotelCity)
            }
        }
    }
}