package com.example.hotels

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Hotel::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract val dao: DAO

}