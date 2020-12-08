package com.example.hotels.ROOM

import androidx.room.*
import com.example.hotels.model.HotelCity

@Dao
interface DaoHotelCity {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(vararg hotelCity: HotelCity)

    @Delete
    fun deleteCity(vararg hotelCity: HotelCity)

    @Query("SELECT * FROM hotelCity")
    fun getAllCity(): List<HotelCity>

//    @Transaction
//    @Query("SELECT * from hotelCity WHERE idCity = :cityId")
//    fun getHotelWithCity(cityId: Int): List<HotelAndCategory>?
}