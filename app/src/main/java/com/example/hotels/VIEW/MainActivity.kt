package com.example.hotels.VIEW

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.R
import com.example.hotels.ListHotelViewModel
import com.example.hotels.ROOM.DAO
import com.example.hotels.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val hotelsListViewModel: ListHotelViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = hotelsListViewModel.adapter
        binding.addHotel.setOnClickListener {
            val intent = Intent(this, AddHotel::class.java)
            startActivity(intent)
        }

        hotelsListViewModel.adapter.hotelsList?.observe(this, Observer {
            hotelsListViewModel.adapter.setData(hotelsListViewModel.adapter.hotelsList)
        })
    }
}