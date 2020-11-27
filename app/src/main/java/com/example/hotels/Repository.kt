package com.example.hotels

import androidx.lifecycle.LiveData
import com.example.hotels.ROOM.DAO
import com.example.hotels.Koin.MyApp
import org.koin.core.KoinComponent
import org.koin.core.inject

class Repository : KoinComponent {

    val dao: DAO by inject()
    var list: LiveData<List<Hotel>?>? = null

    fun addHotel(hotel: Hotel){
        dao.insert(hotel)
    }

    fun getById(id: Int) : Hotel{
        return dao.getById(id)
    }

    fun updateHotel(hotel: Hotel){
        dao.update(hotel)
    }

    fun deleteHotel(hotel: Hotel){
        dao.delete(hotel)
    }

    fun getHotel() : LiveData<List<Hotel>?>? {
        list = dao.getAll()
        return list!!
    }
}