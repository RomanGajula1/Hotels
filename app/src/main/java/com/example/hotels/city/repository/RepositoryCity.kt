package com.example.hotels.city.repository

import com.example.hotels.city.room.DaoCitys
import com.example.hotels.city.model.City
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCity : KoinComponent {
    private val dabCitys: DaoCitys by inject()

    suspend fun insertCity(city: City) {
        dabCitys.insertCity(city)
    }

    fun deleteCity(city: City) {
        dabCitys.deleteCity(city)
    }

    suspend fun updateCity(city: City) {
        dabCitys.updateCity(city)
    }

    fun getById(id: Int): City {
       return dabCitys.getById(id)
    }

    fun getHotelWithCity(cityId: Int) = dabCitys.getHotelWithCity(cityId)

    fun getAllCity() = dabCitys.getAllCity()
}