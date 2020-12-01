package com.example.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject


class UpdateViewModel : ViewModel(), KoinComponent {
    private val repository: RepositoryHotel by inject()
    var name = MutableLiveData("")
    var image = MutableLiveData("")
    var description = MutableLiveData("")

    fun loadForUpdate(id: Int) {
        name.value = repository.getById(id).name.toString()
        image.value = repository.getById(id).image.toString()
        description.value = repository.getById(id).descriptions.toString()
    }

    fun clickUpdateHotel(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val hotel = repository.getById(id)
            hotel.id = id
            hotel.name = name.value
            hotel.image = image.value
            hotel.descriptions = description.value
            repository.updateHotel(hotel)
        }
    }
}