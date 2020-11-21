package com.example.hotels

import android.app.Application
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {

    lateinit var instasce: MyApp
    lateinit var dataBase: DataBase

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule))
        }
        instasce = this
        dataBase = Room.databaseBuilder(this@MyApp, DataBase::class.java, "database")
            .build()
    }
}