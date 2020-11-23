package com.example.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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

        var hotel = Hotel(1, "Roman", "http", "Gajula")

        var db = MyApp().instasce?.dataBase
        var dao: DAO = db!!.dao
        dao.insert(hotel)
        val list: List<Hotel?>? = dao.getAll()
        Log.d("Message", list.toString())

    }
}