package com.example.hotels.Repository

import com.example.hotels.ROOM.DaoHotelCity
import com.example.hotels.model.City
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCity : KoinComponent {
    private val daoHotelCity: DaoHotelCity by inject()

    suspend fun insertCity(city: City) {
        daoHotelCity.insertCity(city)
    }

    fun deleteCity(city: City) {
        daoHotelCity.deleteCity(city)
    }

    suspend fun updateCity(city: City) {
        daoHotelCity.updateCity(city)
    }

    fun getById(id: Int): City{
       return daoHotelCity.getById(id)
    }

    fun getHotelWithCity(cityId: Int) = daoHotelCity.getHotelWithCity(cityId)

    fun getAllCity() = daoHotelCity.getAllCity()
}