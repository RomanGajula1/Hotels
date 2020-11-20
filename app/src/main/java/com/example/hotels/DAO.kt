package com.example.hotels

import androidx.room.*


@Dao
interface DAO {
    @Query("SELECT * FROM model")
    fun getAll(): List<Model?>?

    @Query("SELECT * FROM model WHERE id = :id")
    fun getById(id: Long): Model?

    @Insert
    fun insert(employee: Model?)

    @Update
    fun update(employee: Model?)

    @Delete
    fun delete(employee: Model?)
}