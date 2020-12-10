package com.example.hotels.Koin

import androidx.room.Room
import com.example.hotels.ROOM.DataBase
import org.koin.dsl.module

val commonModule = module {
    single {
        Room.databaseBuilder(get(), DataBase::class.java, "DB")
            .allowMainThreadQueries().build()
    }
}