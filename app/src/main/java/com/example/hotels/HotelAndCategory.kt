package com.example.hotels

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.model.Hotel

class HotelAndCategory(
    @Embedded
    var hotel: Hotel,

    @Relation(parentColumn = "category", entityColumn = "id")
    var hotelCategories: List<Hotel>
)