package com.example.hotels

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotels.VIEW.MainActivity
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.toString as toString

class UpdateViewModel : ViewModel(), KoinComponent {
    val str = "Message"
    private val repository: Repository by inject()
    var nameUpdate = MutableLiveData("")
    var imageUpdate = MutableLiveData("")
    var descriptionUpdate = MutableLiveData("")

    fun loadForUpdate(id: Int){
        nameUpdate.value = repository.getHotel()[id].name.toString()
        imageUpdate.value = repository.getHotel()[id].image.toString()
        descriptionUpdate.value = repository.getHotel()[id].descriptions.toString()
    }

    fun clickUpdateHotel(id: Int, context: Context){
        val hotel = repository.getById(id)
        
        repository.updateHotel()
    }
}