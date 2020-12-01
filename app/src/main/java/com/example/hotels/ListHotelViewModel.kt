package com.example.hotels

import androidx.lifecycle.ViewModel
import com.example.hotels.Adapter.AdapterHotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    val repository: Repository by inject()
    var adapter: AdapterHotel = AdapterHotel()
    var hotelList = repository.getHotel()
}