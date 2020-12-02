package com.example.hotels.VIEW

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.R
import com.example.hotels.viewModel.ListHotelViewModel
import com.example.hotels.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val hotelsListViewModel: ListHotelViewModel by viewModel()

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
    }
    fun clickAddHotel(view: View){
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

        when (id) {
            R.id.hotel -> Toast.makeText(this, "Hotel", Toast.LENGTH_LONG).show()
            R.id.hotelWithCategories -> Toast.makeText(this, "HotelWithCategories", Toast.LENGTH_LONG).show()
        }

        return super.onOptionsItemSelected(item)
    }
}