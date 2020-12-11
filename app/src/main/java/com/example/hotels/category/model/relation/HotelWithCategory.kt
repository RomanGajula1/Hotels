package com.example.hotels.category.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.hotel.model.Hotel
import com.example.hotels.category.model.Category

class HotelWithCategory(
    @Embedded
    var category: Category,

    @Relation(parentColumn = "name", entityColumn = "category")
    var listHotel: List<Hotel>
)