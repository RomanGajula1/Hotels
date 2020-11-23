package com.example.hotels

import androidx.room.*


@Dao
interface DAO{
    @Query("SELECT * FROM hotels")
    fun getAll(): List<Hotel>

    @Query("SELECT * FROM hotels WHERE id = :id")
    fun getById(id: Int): Hotel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg hotel: Hotel)

    @Update
    fun update(hotel: Hotel)

    @Delete
    fun delete(hotel: Hotel)
}