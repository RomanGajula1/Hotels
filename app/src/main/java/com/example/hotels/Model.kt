package com.example.hotels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Model(
    @PrimaryKey
    var id: Int? = null,
    var name: String? = null,
    var image: String? = null,
    var descriptions: String? = null,
) {
}