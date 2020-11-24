package com.example.hotels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hotels.VIEW.MainActivity
import com.example.hotels.VIEW.UpdateHotel
import com.example.hotels.databinding.ActivityAddHotelBinding
import com.example.hotels.databinding.ActivityDetailsHotelBinding
import org.koin.core.KoinComponent
import org.koin.core.inject

class AddHotel : AppCompatActivity(), KoinComponent {

    val addViewModel: AddViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityAddHotelBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_hotel)

        binding.buttonAdd.setOnClickListener {
            addViewModel.addHotel()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}