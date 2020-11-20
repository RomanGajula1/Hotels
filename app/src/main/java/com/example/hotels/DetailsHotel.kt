package com.example.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hotels.databinding.ActivityDetailsHotelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsHotel : AppCompatActivity() {

    val detailsHotelViewModel : DetailsHotelViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityDetailsHotelBinding = DataBindingUtil.setContentView(this, R.layout.activity_details_hotel)

        var id = intent.getIntExtra("id", 0)

        detailsHotelViewModel.loadDetailsHotel(id)

        binding.lifecycleOwner = this
        binding.viewModel = detailsHotelViewModel
    }
}