package com.example.hotels.viewModel

import androidx.lifecycle.ViewModel
import com.example.hotels.Adapter.AdapterHotel
import com.example.hotels.Repository.RepositoryCategory
import com.example.hotels.Repository.RepositoryCity
import com.example.hotels.RepositoryHotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    val repository: RepositoryHotel by inject()
    val repositoryCategory: RepositoryCategory by inject()
    val repositoryCity: RepositoryCity by inject()
    val adapter: AdapterHotel = AdapterHotel()
    var hotelList = repository.getHotel()
}