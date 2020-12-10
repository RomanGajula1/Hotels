package com.example.hotels.category.repository

import com.example.hotels.category.room.DaoCategories
import com.example.hotels.category.model.Categories
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCategory : KoinComponent {
    private val daoCategories: DaoCategories by inject()

    suspend fun insertCategory(categories: Categories) {
        daoCategories.insertCategory(categories)
    }

    suspend fun updateCategory(categories: Categories) {
        daoCategories.updateCategory(categories)
    }

    fun getById(id: Int): Categories {
        return daoCategories.getById(id)
    }

    fun deleteCategory(categories: Categories) {
        daoCategories.deleteCategory(categories)
    }

    fun getHotelWithCategories(categoryId: Int) =
        daoCategories.getHotelWithCategories(categoryId)

    fun getCategory() = daoCategories.getAll()
}