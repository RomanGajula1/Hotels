package com.example.hotels

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.model.Hotel
import com.example.hotels.model.HotelCategories

class HotelAndCategory(
    @Embedded
    var categories: HotelCategories,

    @Relation(parentColumn = "id", entityColumn = "category")
    var hotelCategories: List<HotelCategories>
)