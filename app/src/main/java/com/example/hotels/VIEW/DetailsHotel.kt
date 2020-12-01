package com.example.hotels.VIEW

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.hotels.R
import com.example.hotels.DetailsViewModel
import com.example.hotels.databinding.ActivityDetailsHotelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsHotel : AppCompatActivity() {

    private val detailsViewModel: DetailsViewModel by viewModel()
    var id: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailsHotelBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_details_hotel
        )

        id = intent.getIntExtra("id", 0)

        detailsViewModel.loadDetailsHotel(id)

        binding.apply {
            lifecycleOwner = this@DetailsHotel // владелец жизненного цикла
            viewModel = this@DetailsHotel.detailsViewModel
        }
    }
    fun clickUpdate(view: View){
        val intent = Intent(this@DetailsHotel, UpdateHotel::class.java)
        intent.putExtra("idToUpdate", id)
        startActivity(intent)
    }
}