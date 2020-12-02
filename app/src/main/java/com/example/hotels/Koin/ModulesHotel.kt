package com.example.hotels.Koin

import androidx.room.Room
import com.example.hotels.*
import com.example.hotels.ROOM.DataBase
import com.example.hotels.VIEW.DetailsHotel
import com.example.hotels.viewModel.AddViewModel
import com.example.hotels.viewModel.DetailsViewModel
import com.example.hotels.viewModel.ListHotelViewModel
import com.example.hotels.viewModel.UpdateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListHotelViewModel() }
    viewModel { DetailsViewModel() }
    viewModel { UpdateViewModel() }
    viewModel { AddViewModel() }
    single { RepositoryHotel() }
    single { Room.databaseBuilder(get(), DataBase::class.java, "DataBaseRoom")
        .allowMainThreadQueries().build() }
    single { get<DataBase>().dao }
    single { DetailsHotel() }
}