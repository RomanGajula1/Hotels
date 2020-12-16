package com.example.hotels.hotel.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.hotel.repository.RepositoryHotel
import com.example.hotels.hotel.model.Hotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsViewModel : ViewModel(), KoinComponent {
    private val repository: RepositoryHotel by inject()
    var comment = MutableLiveData("")
    val name = MutableLiveData("")
    val image = MutableLiveData("")
    val description = MutableLiveData("")
    val category = MutableLiveData("")
    val city = MutableLiveData("")

    fun loadDetailsHotel(id: Int) {
        MainScope().launch {
            withContext(Dispatchers.IO) {
                repository.getById(id).let {
                    name.postValue(it.name)
                    description.postValue(it.description)
                    image.postValue(it.image)
                    category.postValue(it.category + ",  ")
                    city.postValue(it.city)
                }
            }
        }
    }
}