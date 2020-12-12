package com.example.hotels.category.room

import androidx.room.*
import com.example.hotels.category.model.relation.HotelWithCategory
import com.example.hotels.category.model.Category

@Dao
interface DaoCategories {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(vararg categories: Category)

    @Delete
    fun deleteCategory(vararg categories: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Query("SELECT * FROM hotelCategories WHERE id = :id")
    fun getById(id: Int): Category

    @Query("SELECT * FROM hotelCategories")
    fun getAll(): List<Category>?

    @Transaction
    @Query("SELECT * from hotelCategories WHERE name = :name")
    fun getHotelWithCategories(name: String): List<HotelWithCategory>?
}