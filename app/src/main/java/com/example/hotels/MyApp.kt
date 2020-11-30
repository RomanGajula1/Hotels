package com.example.hotels

import android.app.Application
import com.example.hotels.Koin.appModule
import com.example.hotels.ROOM.DataBase
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {
    companion object {var instasce: MyApp? = null}
    val dataBase: DataBase by inject()

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule))
        }
        instasce = this
    }
}