package com.example.hotels

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "hotels")
class Hotel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var image: String? = null,
    var descriptions: String? = null,
)