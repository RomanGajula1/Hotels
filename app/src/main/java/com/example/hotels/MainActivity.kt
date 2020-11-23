package com.example.hotels

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val hotelsListViewModel: ListHotelViewModel by inject()
    var TAG = "myLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = hotelsListViewModel.adapter

        var hotel: Hotel = Hotel(1, "Roman", "http", "sdfghjkldsciyuhvb")
        val db = MyApp.instasce?.dataBase
        val dao = db?.dao
        dao?.insert(hotel)
//        Log.d(TAG, MyApp.instasce.toString())
//        Log.d(TAG, db.toString())
//        Log.d(TAG, list.toString())



    }
}