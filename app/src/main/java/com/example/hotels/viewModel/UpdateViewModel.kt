package com.example.hotels.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.RepositoryHotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject


class UpdateViewModel : ViewModel(), KoinComponent {
    private val repository: RepositoryHotel by inject()
    var name = MutableLiveData("")
    var image = MutableLiveData("")
    var description = MutableLiveData("")

    fun loadForUpdate(id: Int) {
        repository.getById(id).let {
            name.value = it.name
            image.value = it.image
            description.value = it.description
        }
    }

    fun clickUpdateHotel(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val hotel = repository.getById(id)
            hotel.id = id
            hotel.name = name.value
            hotel.image = image.value
            hotel.description = description.value
            repository.updateHotel(hotel)
        }
    }
}