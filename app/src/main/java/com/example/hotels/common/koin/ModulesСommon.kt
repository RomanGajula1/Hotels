package com.example.hotels.common.koin

import androidx.room.Room
import com.example.hotels.common.room.DataBase
import org.koin.dsl.module

val commonModule = module {
    single {
        Room.databaseBuilder(get(), DataBase::class.java, "DB")
            .allowMainThreadQueries().build()
    }
}