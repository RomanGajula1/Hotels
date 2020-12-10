package com.example.hotels.model.Relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.model.Hotel
import com.example.hotels.model.Categories

class HotelWithCategory(
    @Embedded
    var categories: Categories,

    @Relation(parentColumn = "id", entityColumn = "category")
    var listHotel: List<Hotel>
)