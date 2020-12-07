package com.example.hotels.VIEW

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.HotelAndCategory
import com.example.hotels.R
import com.example.hotels.ROOM.DaoHotelWithCategories
import com.example.hotels.viewModel.ListHotelViewModel
import com.example.hotels.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val hotelsListViewModel: ListHotelViewModel by viewModel()
    private lateinit var daoHotelWithCategories: DaoHotelWithCategories

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = this@MainActivity.hotelsListViewModel.adapter
        }
        hotelsListViewModel.adapter.setData(hotelsListViewModel.hotelList)
        Log.d("Message", hotelsListViewModel.list.toString())
    }

    fun clickAddHotel(view: View) {
        val intent = Intent(this@MainActivity, AddHotel::class.java)
        startActivity(intent)
    }

    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        var intent = Intent()

        fun clickHotel() {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        fun clickHotelWithCategories() {
            intent = Intent(this, HotelWithCategories::class.java)
            startActivity(intent)
        }

        when (id) {
            R.id.hotel -> clickHotel()
            R.id.hotelWithCategories -> clickHotelWithCategories()
        }

        return super.onOptionsItemSelected(item)
    }
}