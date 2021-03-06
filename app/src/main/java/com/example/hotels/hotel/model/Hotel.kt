package com.example.hotels.hotel.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotels")
class Hotel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var image: String? = null,
    var description: String? = null,
    var category: String? = null,
    var city: String? = null
)