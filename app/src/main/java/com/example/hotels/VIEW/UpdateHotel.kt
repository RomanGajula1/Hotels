package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.hotels.R
import com.example.hotels.Repository
import com.example.hotels.UpdateViewModel
import com.example.hotels.databinding.ActivityUpdateHotelBinding
import org.koin.core.KoinComponent
import org.koin.core.inject

class UpdateHotel : AppCompatActivity(), KoinComponent {

    val updateViewModel: UpdateViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityUpdateHotelBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_update_hotel
        )

        binding.lifecycleOwner = this
        binding.update = updateViewModel

        val id = intent.getIntExtra("idToUpdate", 0)

        updateViewModel.loadForUpdate(id)
        binding.buttonUpdateHotel.setOnClickListener {
            updateViewModel.clickUpdateHotel(id)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}