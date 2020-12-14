package com.example.hotels.city.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.R
import com.example.hotels.category.view.Categoryes
import com.example.hotels.databinding.ActivityCityBinding
import com.example.hotels.hotel.view.MainActivity
import com.example.hotels.city.viewModel.CityViewModel
import org.koin.android.ext.android.inject

class Citys : AppCompatActivity() {

    val cityViewModel: CityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_city)

        binding.apply {
            recyclerViewCity.setHasFixedSize(true)
            recyclerViewCity.layoutManager = LinearLayoutManager(this@Citys)
            recyclerViewCity.adapter = this@Citys.cityViewModel.adapterCity
        }
    }

    fun clickAddCity(view: View) {
        val intent = Intent(this, AddCity::class.java)
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