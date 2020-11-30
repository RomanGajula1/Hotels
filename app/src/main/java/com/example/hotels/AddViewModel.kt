package com.example.hotels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class AddViewModel : ViewModel(), KoinComponent {
    val addName = MutableLiveData("")
    val addImage = MutableLiveData("")
    val addDescription = MutableLiveData("")
    val repository: Repository by inject()

    fun clickAddHotel(){
        viewModelScope.launch(Dispatchers.IO){
            repository.addHotel(Hotel(null, addName.value.toString(), addImage.value.toString(), addDescription.value.toString()))
        }
    }
}