package com.example.hotels.Koin

import com.example.hotels.ROOM.DataBase
import com.example.hotels.Repository.RepositoryCity
import com.example.hotels.viewModel.CityViewModel
import org.koin.dsl.module

val modulesCity = module {
    single { CityViewModel() }
    single { RepositoryCity() }
    single { get<DataBase>().daoHotelCity }
}