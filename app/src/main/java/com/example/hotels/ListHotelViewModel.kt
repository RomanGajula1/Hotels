package com.example.hotels

import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    val repository: Repository by inject()
    var adapter: AdapterHotel = AdapterHotel(null)
    init {
        adapter.hotelsList = repository.getHotel()
    }
}