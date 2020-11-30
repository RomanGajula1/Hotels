package com.example.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var comments = MutableLiveData("")
    var nameHotel: String? = null
    var descriptionText: String? = null
    var photo: String? = null
    fun loadDetailsHotel(id: Int){
        nameHotel = repository.getById(id).name.toString()
        descriptionText = repository.getById(id).descriptions.toString()
        photo = repository.getById(id).image.toString()
    }
}