package com.example.hotels

import com.example.hotels.ROOM.DaoHotel
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryHotel : KoinComponent {

    val dao: DaoHotel by inject()

    suspend fun addHotel(hotel: Hotel){
        dao.insert(hotel)
    }

    fun getById(id: Int) : Hotel{
        return dao.getById(id)
    }

    suspend fun updateHotel(hotel: Hotel){
        dao.update(hotel)
    }

    fun deleteHotel(hotel: Hotel){
        dao.delete(hotel)
    }

    fun getHotel() : List<Hotel>? {
        return dao.getAll()
    }
}