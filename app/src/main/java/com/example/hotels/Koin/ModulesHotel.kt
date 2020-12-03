package com.example.hotels.Koin

import androidx.room.Room
import com.example.hotels.*
import com.example.hotels.ROOM.DataBase
import com.example.hotels.Repository.RepositoryCategory
import com.example.hotels.VIEW.DetailsHotel
import com.example.hotels.viewModel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListHotelViewModel() }
    viewModel { DetailsViewModel() }
    viewModel { UpdateViewModel() }
    viewModel { CategoryViewModel() }
    viewModel { AddViewModel() }
    single { RepositoryHotel() }
    single { RepositoryCategory() }
    single {
        Room.databaseBuilder(get(), DataBase::class.java, "DB")
            .allowMainThreadQueries().build()
    }
    single { get<DataBase>().dao }
    single { get<DataBase>().daoHotelWithCategories }
    single { DetailsHotel() }
}