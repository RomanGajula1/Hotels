package com.example.hotels.Koin

import androidx.room.Room
import com.example.hotels.*
import com.example.hotels.ROOM.DataBase
import com.example.hotels.VIEW.DetailsHotel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListHotelViewModel() }
    viewModel { DetailsViewModel() }
    viewModel { UpdateViewModel() }
    viewModel { AddViewModel() }
    single { Repository() }
    single { Room.databaseBuilder(get(), DataBase::class.java, "MyBDRoom")
        .allowMainThreadQueries().build() }
    single { get<DataBase>().dao }
    single { DetailsHotel() }
}