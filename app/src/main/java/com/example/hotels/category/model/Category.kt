package com.example.hotels.category.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotelCategories")
class Category(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null
)