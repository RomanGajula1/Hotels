package com.example.hotels

import androidx.room.Database
import androidx.room.Room
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListHotelViewModel() }
    viewModel { DetailsHotelViewModel() }
    single { Repository() }
    single { Room.databaseBuilder(get(), DataBase::class.java, "MyBD")
        .allowMainThreadQueries().build() }
    single { get<DataBase>().dao }
}