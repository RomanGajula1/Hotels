package com.example.hotels.VIEW

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.Hotel
import com.example.hotels.R
import com.example.hotels.ListHotelViewModel
import com.example.hotels.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val hotelsListViewModel: ListHotelViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = this@MainActivity.hotelsListViewModel.adapter
            addHotel.setOnClickListener {
                val intent = Intent(this@MainActivity, AddHotel::class.java)
                startActivity(intent)
            }
        }
        hotelsListViewModel.adapter.setData(hotelsListViewModel.hotelList)
    }
}