package com.example.hotels.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotels.RepositoryHotel
import com.example.hotels.model.Hotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsViewModel : ViewModel(), KoinComponent {
    private val repository: RepositoryHotel by inject()
    var comment = MutableLiveData("")
    val hotel: Hotel = Hotel()

    fun loadDetailsHotel(id: Int) {
        repository.getById(id).let {
            hotel.name = it.name
            hotel.description = it.description
            hotel.image = it.image
        }
    }
}