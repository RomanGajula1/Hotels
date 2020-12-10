package com.example.hotels.model.Relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.model.Hotel
import com.example.hotels.model.City

class HotelWithCity(
    @Embedded
    val city: City,

    @Relation(parentColumn = "idCity", entityColumn = "city", entity = Hotel::class)
    val hoteliCity: List<Hotel>
)