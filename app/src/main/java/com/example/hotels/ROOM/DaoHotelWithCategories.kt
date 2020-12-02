package com.example.hotels.ROOM

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.hotels.HotelAndCategory
import com.example.hotels.model.HotelCategories

@Dao
interface DaoHotelWithCategories {

    @Insert
    fun insertCategory(hotelCategories: HotelCategories)

    @Transaction
    @Query("SELECT * from hotels WHERE category = :category")
    fun getHotelWithCategories(category: Int): List<HotelAndCategory?>?
}