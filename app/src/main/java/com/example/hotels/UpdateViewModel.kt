package com.example.hotels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.Koin.MyApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject


class UpdateViewModel : ViewModel(), KoinComponent {
    val str = "Message"
    private val repository: Repository by inject()
    var nameUpdate = MutableLiveData("")
    var imageUpdate = MutableLiveData("")
    var descriptionUpdate = MutableLiveData("")

    fun loadForUpdate(id: Int){
        nameUpdate.value = repository.getById(id).name.toString()
        imageUpdate.value = repository.getById(id).image.toString()
        descriptionUpdate.value = repository.getById(id).descriptions.toString()
    }

    fun clickUpdateHotel(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val hotel = repository.getById(id)
            hotel.id = id
            hotel.name = nameUpdate.value
            hotel.image = imageUpdate.value
            hotel.descriptions = descriptionUpdate.value
            repository.updateHotel(hotel)
        }
    }
}