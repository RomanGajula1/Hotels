package com.example.hotels.ROOM

import androidx.room.*
import com.example.hotels.HotelAndCategory
import com.example.hotels.model.Hotel
import com.example.hotels.model.HotelCategories

@Dao
interface DaoHotelWithCategories {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(vararg hotelCategories: HotelCategories)

    @Delete
    fun deleteCategory(vararg hotelCategories: HotelCategories)

    @Query("SELECT * FROM hotelCategories")
    fun getAll(): List<HotelCategories>?

    @Transaction
    @Query("SELECT * from hotels WHERE category = :category")
    fun getHotelWithCategories(category: Int): List<HotelAndCategory?>?
}