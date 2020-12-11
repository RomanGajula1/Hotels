package com.example.hotels.city.model.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.hotels.city.model.City
import com.example.hotels.hotel.model.Hotel

class HotelWithCity(
    @Embedded
    val city: City,

    @Relation(parentColumn = "id", entityColumn = "city", entity = Hotel::class)
    val hoteliCity: List<Hotel>
)