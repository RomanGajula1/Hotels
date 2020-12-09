package com.example.hotels.Koin

import com.example.hotels.ROOM.DataBase
import com.example.hotels.Repository.RepositoryCity
import com.example.hotels.viewModel.CityViewModel
import com.example.hotels.viewModel.UpdateCityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modulesCity = module {
    viewModel { CityViewModel() }
    viewModel { UpdateCityViewModel() }
    single { RepositoryCity() }
    single { get<DataBase>().daoHotelCity }
}