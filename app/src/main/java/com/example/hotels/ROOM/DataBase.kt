package com.example.hotels.ROOM

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hotels.Hotel


@Database(entities = [Hotel::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract val dao: DAO

}