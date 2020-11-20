package com.example.hotels

import androidx.room.*


@Dao
interface DAO {
    @Query("SELECT * FROM hotel")
    fun getAll(): List<Model?>?

    @Query("SELECT * FROM hotel WHERE id = :id")
    fun getById(id: Long): Model?

    @Insert
    fun insert(employee: Model?)

    @Update
    fun update(employee: Model?)

    @Delete
    fun delete(employee: Model?)
}