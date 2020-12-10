package com.example.hotels.Koin

import androidx.room.Room
import com.example.hotels.*
import com.example.hotels.ROOM.DataBase
import com.example.hotels.VIEW.DetailsHotel
import com.example.hotels.viewModel.*
import com.example.hotels.viewModel.AddHotelViewModel
import com.example.hotels.viewModel.UpdateHotelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListHotelViewModel() }
    viewModel { DetailsViewModel() }
    viewModel { UpdateHotelViewModel() }
    viewModel { AddHotelViewModel() }
    single { RepositoryHotel() }
    single { get<DataBase>().dao }
    single { DetailsHotel() }
}