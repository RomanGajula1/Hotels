package com.example.hotels

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.hotels.databinding.ActivityDetailsHotelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsHotel : AppCompatActivity() {
    val hotelInfoViewModel : DetailsViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityDetailsHotelBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_hotel)

        var id = intent.getIntExtra("id", 0)

        hotelInfoViewModel.loadDetailsHotel(id)

        binding.lifecycleOwner = this
        binding.viewModel = hotelInfoViewModel
    }
}