package com.example.hotels.ROOM

import androidx.room.*
import com.example.hotels.model.Relation.HotelWithCategory
import com.example.hotels.model.Categories

@Dao
interface DaoCategories {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(vararg categories: Categories)

    @Delete
    fun deleteCategory(vararg categories: Categories)

    @Update
    suspend fun updateCategory(categories: Categories)

    @Query("SELECT * FROM hotelCategories WHERE id = :id")
    fun getById(id: Int): Categories

    @Query("SELECT * FROM hotelCategories")
    fun getAll(): List<Categories>?

    @Transaction
    @Query("SELECT * from hotelCategories WHERE id = :categoryId")
    fun getHotelWithCategories(categoryId: Int): List<HotelWithCategory>?
}