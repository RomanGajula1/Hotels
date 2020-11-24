package com.example.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.hotels.databinding.ActivityUpdateHotelBinding
import org.koin.core.KoinComponent
import org.koin.core.inject
import kotlin.math.log

class UpdateHotel : AppCompatActivity(), KoinComponent {

    val updateViewModel: UpdateViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityUpdateHotelBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_hotel)

        var id = intent.getIntExtra("id", 0)

        updateViewModel.loadForUpdate(id)
        updateViewModel.clickUpdateHotel(id, this, binding.buttonUpdateHotel)
        binding.lifecycleOwner = this
        binding.update = updateViewModel
    }
}