package com.example.hotels.ROOM

import androidx.room.*
import com.example.hotels.model.Relation.HotelAndCategory
import com.example.hotels.model.HotelCategories

@Dao
interface DaoHotelWithCategories {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(vararg categories: HotelCategories)

    @Delete
    fun deleteCategory(vararg categories: HotelCategories)

    @Update
    suspend fun updateCategory(categories: HotelCategories)

    @Query("SELECT * FROM hotelCategories WHERE id = :id")
    fun getById(id: Int): HotelCategories

    @Query("SELECT * FROM hotelCategories")
    fun getAll(): List<HotelCategories>?

    @Transaction
    @Query("SELECT * from hotelCategories WHERE id = :categoryId")
    fun getHotelWithCategories(categoryId: Int): List<HotelAndCategory>?
}