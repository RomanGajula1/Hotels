package com.example.hotels.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.RepositoryHotel
import com.example.hotels.model.Hotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class AddViewModel : ViewModel(), KoinComponent {
    val name = MutableLiveData("")
    val image = MutableLiveData("")
    val description = MutableLiveData("")
    private val repository: RepositoryHotel by inject()

    fun clickAddHotel() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addHotel(
                Hotel(
                    null,
                    name.value.toString(),
                    image.value.toString(),
                    description.value.toString()
                )
            )
        }
    }
}