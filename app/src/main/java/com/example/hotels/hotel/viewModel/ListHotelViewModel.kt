package com.example.hotels.hotel.viewModel

import androidx.lifecycle.ViewModel
import com.example.hotels.hotel.adapter.AdapterHotel
import com.example.hotels.category.repository.RepositoryCategory
import com.example.hotels.city.repository.RepositoryCity
import com.example.hotels.hotel.repository.RepositoryHotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    val repository: RepositoryHotel by inject()
    val repositoryCategory: RepositoryCategory by inject()
    val repositoryCity: RepositoryCity by inject()
    val adapter: AdapterHotel = AdapterHotel()
    var hotelList = repository.getHotel()
}