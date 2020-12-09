package com.example.hotels.ROOM

import androidx.room.*
import com.example.hotels.VIEW.City
import com.example.hotels.model.HotelCity
import com.example.hotels.model.Relation.HotelWithCity

@Dao
interface DaoHotelCity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(vararg hotelCity: HotelCity)

    @Delete
    fun deleteCity(vararg hotelCity: HotelCity)

    @Update
    fun update(city: HotelCity)

    @Query("SELECT * FROM hotelCity")
    fun getAllCity(): List<HotelCity>

    @Transaction
    @Query("SELECT * from hotelCity WHERE idCity = :cityId")
    fun getHotelWithCity(cityId: Int): List<HotelWithCity>?
}