package com.example.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = hotelsListViewModel.adapter

        val hotel = Hotel(1, "Elite Hotel", "https://bestvietnam.ru/wp-content/uploads/2019/09/%D0%BE%D1%82%D0%B5%D0%BB%D1%8C.jpg", "Gajula")

        val db = MyApp.instasce?.dataBase
        val dao = db?.dao
        dao?.insert(listOf(hotel))
        val list: List<Hotel?> = dao?.getAll()!!
        Log.d(TAG, MyApp.instasce.toString())
        Log.d(TAG, db.toString())
        Log.d(TAG, list.toString())


    }
}