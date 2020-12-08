package com.example.hotels.Repository

import com.example.hotels.ROOM.DaoHotelCity
import com.example.hotels.model.HotelCity
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCity : KoinComponent {
    private val daoHotelCity: DaoHotelCity by inject()

    fun insertCity(hotelCity: HotelCity) {
        daoHotelCity.insertCity(hotelCity)
    }

    fun deleteCity(hotelCity: HotelCity) {
        daoHotelCity.deleteCity(hotelCity)
    }

    fun getHotelWithCity(cityId: Int) = daoHotelCity.getHotelWithCity(cityId)

    fun getAllCity() = daoHotelCity.getAllCity()
}