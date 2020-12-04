package com.example.hotels.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "hotelCategories")
class HotelCategories(
    @PrimaryKey
    var id: Int? = null,
    var category: Int? = null
)