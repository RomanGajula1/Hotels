package com.example.hotels

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_details_hotel.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class DetailsViewModel : ViewModel(), KoinComponent {
    private val repository: Repository by inject()
    var comments = MutableLiveData("")
    var nameHotel: String? = null
    var descriptionText: String? = null
    var photo: String? = null
    fun loadDetailsHotel(id: Int){
        nameHotel = repository.getHotel()[id].name.toString()
        descriptionText = repository.getHotel()[id].descriptions.toString()
        photo = repository.getHotel()[id].image.toString()
    }

    fun clickUpdate(id: Int, context: Context, view: View){
        view.setOnClickListener {
            val intent = Intent(context, UpdateHotel::class.java)
            intent.putExtra("id", id)
            context.startActivity(intent)
        }
    }
}