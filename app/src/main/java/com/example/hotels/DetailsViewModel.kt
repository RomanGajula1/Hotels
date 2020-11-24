package com.example.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var comments = MutableLiveData("")
    var nameHotel = String()
    var descriptionText = String()
    var photo = String()
    fun loadDetailsHotel(id: Int){
        nameHotel = repository.getHotel()[id].name.toString()
        descriptionText = repository.getHotel()[id].descriptions.toString()
        photo = repository.getHotel()[id].image.toString()
    }
}