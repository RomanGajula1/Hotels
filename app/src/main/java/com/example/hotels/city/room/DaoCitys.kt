package com.example.hotels.city.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hotels.city.model.City
import com.example.hotels.city.model.relation.HotelWithCity

@Dao
interface DaoCitys {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(vararg city: City)

    @Delete
    suspend fun deleteCity(vararg city: City)

    @Update
    suspend fun updateCity(city: City)

    @Query("SELECT * FROM hotelCity WHERE id = :id")
    suspend fun getById(id: Int): City

    @Query("SELECT * FROM hotelCity")
    fun getAllCity(): LiveData<List<City>>

    @Transaction
    @Query("SELECT * from hotelCity WHERE name = :name")
    fun getHotelWithCity(name: String): LiveData<List<HotelWithCity>>
}