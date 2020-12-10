package com.example.hotels

import android.app.Application
import com.example.hotels.hotel.koin.appModule
import com.example.hotels.common.koin.commonModule
import com.example.hotels.category.koin.modulesCategory
import com.example.hotels.city.koin.modulesCity
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {
    companion object {
        var instance: MyApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(commonModule, appModule, modulesCity, modulesCategory))
        }
        instance = this
    }
}