package com.example.hotels

import androidx.lifecycle.ViewModel
import com.example.hotels.Adapter.AdapterHotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    val repository: RepositoryHotel by inject()
    val adapter: AdapterHotel = AdapterHotel()
    var hotelList = repository.getHotel()
}