package com.example.hotels.category.repository

import com.example.hotels.category.room.DaoCategories
import com.example.hotels.category.model.Category
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCategory : KoinComponent {
    private val daoCategories: DaoCategories by inject()

    suspend fun insertCategory(category: Category) {
        daoCategories.insertCategory(category)
    }

    suspend fun updateCategory(category: Category) {
        daoCategories.updateCategory(category)
    }

    fun getById(id: Int): Category {
        return daoCategories.getById(id)
    }

    fun deleteCategory(category: Category) {
        daoCategories.deleteCategory(category)
    }

    fun getHotelWithCategories(name: String) =
        daoCategories.getHotelWithCategories(name)

    fun getCategory() = daoCategories.getAll()
}