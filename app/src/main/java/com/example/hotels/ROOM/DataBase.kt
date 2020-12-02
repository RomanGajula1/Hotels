package com.example.hotels.ROOM

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotels.model.Hotel
import com.example.hotels.model.HotelCategories


@Database(entities = [Hotel::class, HotelCategories::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract val dao: DaoHotel
    abstract val daoHotelWithCategories: DaoHotelWithCategories
}