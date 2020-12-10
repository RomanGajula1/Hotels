package com.example.hotels.ROOM

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotels.model.Hotel
import com.example.hotels.model.Categories
import com.example.hotels.model.City


@Database(entities = [Hotel::class, Categories::class, City::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract val dao: DaoHotel
    abstract val daoCategories: DaoCategories
    abstract val daoCitys: DaoCitys
}