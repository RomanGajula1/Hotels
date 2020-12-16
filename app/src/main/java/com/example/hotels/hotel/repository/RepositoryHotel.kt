package com.example.hotels.hotel.repository

import com.example.hotels.hotel.room.DaoHotel
import com.example.hotels.hotel.model.Hotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryHotel : KoinComponent {

    private val dao: DaoHotel by inject()

    suspend fun addHotel(hotel: Hotel) {
        dao.insert(hotel)
    }

    suspend fun getById(id: Int) = dao.getById(id)

    suspend fun updateHotel(hotel: Hotel) {
        dao.update(hotel)
    }

    suspend fun deleteHotel(hotel: Hotel) {
        dao.delete(hotel)
    }

    fun getHotel() = dao.getAll()
}