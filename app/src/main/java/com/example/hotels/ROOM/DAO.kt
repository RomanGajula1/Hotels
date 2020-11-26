package com.example.hotels.ROOM

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.hotels.Hotel


@Dao
interface DAO{
    @Query("SELECT * FROM hotels")
    fun getAll(): LiveData<List<Hotel>?>?

    @Query("SELECT * FROM hotels WHERE id = :id")
    fun getById(id: Int): Hotel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg hotel: Hotel)

    @Update
    fun update(hotel: Hotel)

    @Delete
    fun delete(hotel: Hotel)
}