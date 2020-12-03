package com.example.hotels

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.model.Hotel

class HotelAndCategory {
    @Embedded
    lateinit var hotel: Hotel

    @Relation(parentColumn = "category", entityColumn = "category")
    lateinit var hotelCategories: List<Hotel>
}