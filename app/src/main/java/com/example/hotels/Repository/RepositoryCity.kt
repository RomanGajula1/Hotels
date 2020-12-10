package com.example.hotels.Repository

import com.example.hotels.ROOM.DaoCitys
import com.example.hotels.model.City
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCity : KoinComponent {
    private val daoCitys: DaoCitys by inject()

    suspend fun insertCity(city: City) {
        daoCitys.insertCity(city)
    }

    fun deleteCity(city: City) {
        daoCitys.deleteCity(city)
    }

    suspend fun updateCity(city: City) {
        daoCitys.updateCity(city)
    }

    fun getById(id: Int): City{
       return daoCitys.getById(id)
    }

    fun getHotelWithCity(cityId: Int) = daoCitys.getHotelWithCity(cityId)

    fun getAllCity() = daoCitys.getAllCity()
}