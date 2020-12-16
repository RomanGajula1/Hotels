package com.example.hotels.hotel.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.R
import com.example.hotels.category.view.Categoryes
import com.example.hotels.city.view.Citys
import com.example.hotels.hotel.viewModel.ListHotelViewModel
import com.example.hotels.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    private val hotelsListViewModel: ListHotelViewModel by viewModel()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        hotelsListViewModel.adapter.context = this@MainActivity

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = this@MainActivity.hotelsListViewModel.adapter
        }

        hotelsListViewModel.hotelList.observe(this, Observer {
            hotelsListViewModel.adapter.setDataHotel(it)
        })

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

        fun clickCategories() {
            intent = Intent(this, Categoryes::class.java)
            startActivity(intent)
        }

        fun clickCity() {
            intent = Intent(this, Citys::class.java)
            startActivity(intent)
        }

        when (id) {
            R.id.hotel -> clickHotel()
            R.id.hotelWithCategories -> clickCategories()
            R.id.hotelCity -> clickCity()
        }

        return super.onOptionsItemSelected(item)
    }
}