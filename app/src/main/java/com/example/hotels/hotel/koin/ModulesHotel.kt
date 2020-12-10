package com.example.hotels.hotel.koin

import com.example.hotels.common.room.DataBase
import com.example.hotels.hotel.view.DetailsHotel
import com.example.hotels.hotel.repository.RepositoryHotel
import com.example.hotels.hotel.viewModel.DetailsViewModel
import com.example.hotels.hotel.viewModel.ListHotelViewModel
import com.example.hotels.hotel.viewModel.AddHotelViewModel
import com.example.hotels.hotel.viewModel.UpdateHotelViewModel
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