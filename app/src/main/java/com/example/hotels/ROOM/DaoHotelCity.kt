package com.example.hotels.ROOM

import androidx.room.*
import com.example.hotels.model.City
import com.example.hotels.model.Relation.HotelWithCity

@Dao
interface DaoHotelCity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(vararg city: City)

    @Delete
    fun deleteCity(vararg city: City)

    @Update
    suspend fun updateCity(city: City)

    @Query("SELECT * FROM hotelCity WHERE idCity = :id")
    fun getById(id: Int): City

    @Query("SELECT * FROM hotelCity")
    fun getAllCity(): List<City>

    @Transaction
    @Query("SELECT * from hotelCity WHERE idCity = :cityId")
    fun getHotelWithCity(cityId: Int): List<HotelWithCity>?
}