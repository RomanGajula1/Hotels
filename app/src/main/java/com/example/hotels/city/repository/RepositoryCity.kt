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

    suspend fun deleteCity(city: City) {
        dabCitys.deleteCity(city)
    }

    suspend fun updateCity(city: City) {
        dabCitys.updateCity(city)
    }

    suspend fun getById(id: Int): City {
        return dabCitys.getById(id)
    }

    fun getHotelWithCity(name: String) = dabCitys.getHotelWithCity(name)

    fun getAllCity() = dabCitys.getAllCity()
}