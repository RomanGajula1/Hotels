package com.example.hotels.Repository

import com.example.hotels.ROOM.DaoHotelWithCategories
import com.example.hotels.model.HotelCategories
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCategory : KoinComponent {
    private val daoHotelWithCategories: DaoHotelWithCategories by inject()

    fun insert(hotelCategories: HotelCategories){
        daoHotelWithCategories.insertCategory(hotelCategories)
    }
}