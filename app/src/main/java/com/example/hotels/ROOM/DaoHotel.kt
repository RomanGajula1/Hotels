package com.example.hotels.ROOM

import androidx.room.*
import com.example.hotels.model.Hotel

@Dao
interface DaoHotel {
    @Query("SELECT * FROM hotels")
    fun getAll(): List<Hotel>?

    @Query("SELECT * FROM hotels WHERE id = :id")
    fun getById(id: Int): Hotel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg hotel: Hotel)

    @Update
    suspend fun update(hotel: Hotel)

    @Delete
    fun delete(hotel: Hotel)
}