package com.example.hotels.city.koin

import com.example.hotels.common.room.DataBase
import com.example.hotels.city.repository.RepositoryCity
import com.example.hotels.city.viewModel.CityViewModel
import com.example.hotels.city.viewModel.UpdateCityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modulesCity = module {
    viewModel { CityViewModel() }
    viewModel { UpdateCityViewModel() }
    single { RepositoryCity() }
    single { get<DataBase>().daoCitys }
}