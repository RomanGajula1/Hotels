package com.example.hotels.category.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hotelCategories")
class Categories(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var category: Int? = null
)