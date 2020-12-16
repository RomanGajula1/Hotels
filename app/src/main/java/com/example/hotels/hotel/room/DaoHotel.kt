package com.example.hotels.hotel.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hotels.hotel.model.Hotel

@Dao
interface DaoHotel {
    @Query("SELECT * FROM hotels")
    fun getAll(): LiveData<List<Hotel>>

    @Query("SELECT * FROM hotels WHERE id = :id")
    suspend fun getById(id: Int): Hotel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg hotel: Hotel)

    @Update
    suspend fun update(hotel: Hotel)

    @Delete
    suspend fun delete(hotel: Hotel)
}