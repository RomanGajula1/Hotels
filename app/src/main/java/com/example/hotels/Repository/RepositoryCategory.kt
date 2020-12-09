package com.example.hotels.Repository

import com.example.hotels.ROOM.DaoHotelWithCategories
import com.example.hotels.model.HotelCategories
import org.koin.core.KoinComponent
import org.koin.core.inject

class RepositoryCategory : KoinComponent {
    private val daoHotelWithCategories: DaoHotelWithCategories by inject()

    suspend fun insertCategory(hotelCategories: HotelCategories) {
        daoHotelWithCategories.insertCategory(hotelCategories)
    }

    suspend fun updateCategory(hotelCategories: HotelCategories) {
        daoHotelWithCategories.updateCategory(hotelCategories)
    }

    fun getById(id: Int): HotelCategories {
        return daoHotelWithCategories.getById(id)
    }

    fun deleteCategory(hotelCategories: HotelCategories) {
        daoHotelWithCategories.deleteCategory(hotelCategories)
    }

    fun getHotelWithCategories(categoryId: Int) =
        daoHotelWithCategories.getHotelWithCategories(categoryId)

    fun getCategory() = daoHotelWithCategories.getAll()
}