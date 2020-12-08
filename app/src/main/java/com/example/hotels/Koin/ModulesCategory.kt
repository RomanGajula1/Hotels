package com.example.hotels.Koin

import com.example.hotels.ROOM.DataBase
import com.example.hotels.Repository.RepositoryCategory
import com.example.hotels.viewModel.CategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modulesCategory = module {
    viewModel { CategoryViewModel() }
    single { RepositoryCategory() }
    single { get<DataBase>().daoHotelWithCategories }
}