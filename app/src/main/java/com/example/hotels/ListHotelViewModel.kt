package com.example.hotels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.Adapter
import com.example.hotels.Hotel
import com.example.hotels.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    val repository: Repository by inject()
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