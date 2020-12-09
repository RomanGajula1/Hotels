package com.example.hotels.Repository

import com.example.hotels.ROOM.DaoHotelCity
import com.example.hotels.model.Hotel
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

    suspend fun updateCity(city: HotelCity) {
        daoHotelCity.updateCity(city)
    }

    fun getById(id: Int): HotelCity{
       return daoHotelCity.getById(id)
    }

    fun getHotelWithCity(cityId: Int) = daoHotelCity.getHotelWithCity(cityId)

    fun getAllCity() = daoHotelCity.getAllCity()
}