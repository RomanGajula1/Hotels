package com.example.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsHotelViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var comments = MutableLiveData("")
    var nameHotel = String()
    var descriptionText = String()
    var photo = String()


    fun loadDetailsHotel(id: Int){
        nameHotel = repository.getListHotel()[id].name.toString()
        descriptionText = repository.getListHotel()[id].descriptions.toString()
        photo = repository.getListHotel()[id].image.toString()
    }
}