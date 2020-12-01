package com.example.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsViewModel : ViewModel(), KoinComponent {
    private val repository: RepositoryHotel by inject()
    var comment = MutableLiveData("")
    val hotel: Hotel = Hotel()
    fun loadDetailsHotel(id: Int) {
        repository.getById(id).let {
            hotel.name = it.name
            hotel.descriptions = it.descriptions
            hotel.image = it.image
        }
    }
}