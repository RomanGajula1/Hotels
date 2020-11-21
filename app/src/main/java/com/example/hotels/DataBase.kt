package com.example.hotels

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [Hotel::class], version = 1)
abstract class DataBase : RoomDatabase() {
    private var INSTANCE: DataBase? = null
    abstract val dao: DAO

}