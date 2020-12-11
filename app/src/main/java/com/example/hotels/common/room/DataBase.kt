package com.example.hotels.common.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotels.hotel.model.Hotel
import com.example.hotels.hotel.room.DaoHotel
import com.example.hotels.category.model.Category
import com.example.hotels.category.room.DaoCategories
import com.example.hotels.city.model.City
import com.example.hotels.city.room.DaoCitys


@Database(entities = [Hotel::class, Category::class, City::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract val dao: DaoHotel
    abstract val daoCategories: DaoCategories
    abstract val daoCitys: DaoCitys
}