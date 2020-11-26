package com.example.hotels

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hotels.VIEW.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class AddViewModel : ViewModel(), KoinComponent {
    val addName = MutableLiveData("")
    val addImage = MutableLiveData("")
    val addDescription = MutableLiveData("")
    val repository: Repository by inject()

    fun clickAddHotel(context: Context, view: View){
        view.setOnClickListener{
            val intent = Intent(context, MainActivity::class.java)
            repository.addHotel(Hotel(null, addName.value.toString(), addImage.value.toString(), addDescription.value.toString()))
            context.startActivity(intent)
        }
    }
}