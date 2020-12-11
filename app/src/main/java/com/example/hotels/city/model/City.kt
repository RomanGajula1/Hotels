package com.example.hotels.city.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotelCity")
class City(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null
)