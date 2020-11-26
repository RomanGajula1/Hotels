package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hotels.AddViewModel
import com.example.hotels.R
import com.example.hotels.databinding.ActivityAddHotelBinding
import org.koin.core.KoinComponent
import org.koin.core.inject

class AddHotel : AppCompatActivity(), KoinComponent {

    val addViewModel: AddViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityAddHotelBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_hotel)

        binding.lifecycleOwner = this
        binding.addViewModel = addViewModel

        binding.buttonAdd.setOnClickListener {
            addViewModel.clickAddHotel()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}