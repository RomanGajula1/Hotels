package com.example.hotels

import androidx.lifecycle.LiveData
import com.example.hotels.ROOM.DAO
import org.koin.core.KoinComponent
import org.koin.core.inject

class Repository : KoinComponent {

    val dao: DAO by inject()
    var list: List<Hotel>? = null

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