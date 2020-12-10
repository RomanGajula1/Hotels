package com.example.hotels.category.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.hotel.model.Hotel
import com.example.hotels.category.model.Categories

class HotelWithCategory(
    @Embedded
    var categories: Categories,

    @Relation(parentColumn = "id", entityColumn = "category")
    var listHotel: List<Hotel>
)