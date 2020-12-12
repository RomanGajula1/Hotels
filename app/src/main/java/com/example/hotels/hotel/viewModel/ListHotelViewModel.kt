package com.example.hotels.hotel.viewModel

import androidx.lifecycle.ViewModel
import com.example.hotels.hotel.adapter.AdapterHotel
import com.example.hotels.category.repository.RepositoryCategory
import com.example.hotels.city.repository.RepositoryCity
import com.example.hotels.hotel.model.Hotel
import com.example.hotels.hotel.repository.RepositoryHotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    private val repository: RepositoryHotel by inject()
    private val repositoryCategory: RepositoryCategory by inject()
    private val repositoryCity: RepositoryCity by inject()
    val adapter: AdapterHotel = AdapterHotel()
    var hotelList = repository.getHotel()

    fun deleteHotel(hotel: Hotel){
        repository.deleteHotel(hotel)
    }

    fun getHotelWithCategories(name: String) = repositoryCategory.getHotelWithCategories(name)
    fun getHotelWithCity(name: String) = repositoryCity.getHotelWithCity(name)
}