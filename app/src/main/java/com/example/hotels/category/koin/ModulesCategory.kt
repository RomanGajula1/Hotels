package com.example.hotels.category.koin

import com.example.hotels.common.room.DataBase
import com.example.hotels.category.repository.RepositoryCategory
import com.example.hotels.category.viewModel.CategoryViewModel
import com.example.hotels.category.viewModel.UpdateCategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modulesCategory = module {
    viewModel { CategoryViewModel() }
    viewModel { UpdateCategoryViewModel() }
    single { RepositoryCategory() }
    single { get<DataBase>().daoCategories }
}