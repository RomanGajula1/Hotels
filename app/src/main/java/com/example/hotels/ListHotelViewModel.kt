package com.example.hotels

import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class ListHotelViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var adapter: Adapter = Adapter(null)
    lateinit var list: ArrayList<Hotel>
    init {
        adapter.hotelsList = repository.getListHotel()
    }

}