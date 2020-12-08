package com.example.hotels.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotelCategories")
class HotelCategories(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var category: Int? = null
)