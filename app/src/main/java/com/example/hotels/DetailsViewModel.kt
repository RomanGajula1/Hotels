package com.example.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var comment = MutableLiveData("")
    var name: String? = null
    var description: String? = null
    var photo: String? = null
    fun loadDetailsHotel(id: Int) {
        name = repository.getById(id).name.toString()
        description = repository.getById(id).descriptions.toString()
        photo = repository.getById(id).image.toString()
    }
}