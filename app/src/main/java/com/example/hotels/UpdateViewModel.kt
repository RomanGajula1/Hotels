package com.example.hotels

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hotels.VIEW.MainActivity
import org.koin.core.KoinComponent
import org.koin.core.inject

class UpdateViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var nameUpdate = MutableLiveData("")
    var imageUpdate = MutableLiveData("")
    var descriptionUpdate = MutableLiveData("")

    fun loadForUpdate(id: Int){
        nameUpdate.value = repository.getHotel()[id].name.toString()
        imageUpdate.value = repository.getHotel()[id].image.toString()
        descriptionUpdate.value = repository.getHotel()[id].descriptions.toString()
    }

    fun clickUpdateHotel(id: Int, context: Context, view: View){
        view.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            val hotel = Hotel(id, nameUpdate.toString(), imageUpdate.toString(), descriptionUpdate.toString())
            repository.updateHotel(hotel)
            context.startActivity(intent)
        }
    }
}