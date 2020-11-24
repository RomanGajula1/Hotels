package com.example.hotels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var adapter: Adapter = Adapter(null)
    init {
        adapter.hotelsList = repository.getHotel()
    }

    fun deleteHotel(hotel: Hotel){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteHotel(hotel)
        }
    }
}