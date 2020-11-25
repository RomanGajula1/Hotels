package com.example.hotels

import android.util.Log
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

    fun addHotel(){
        repository.addHotel(Hotel(9, addName.value.toString(), addImage.value.toString(), addDescription.value.toString()))
    }
}