package com.example.hotels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.VIEW.AddHotel
import com.example.hotels.VIEW.MainActivity
import com.example.hotels.databinding.ActivityHotelWithCategoriesBinding
import com.example.hotels.viewModel.CategoryViewModel
import com.example.hotels.viewModel.ListHotelViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelWithCategories : AppCompatActivity() {

    private val categoryViewModel: CategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHotelWithCategoriesBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_hotel_with_categories)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@HotelWithCategories)
        }
    }

    fun clickAddCategory(view: View){
        val intent = Intent(this, AddCategory::class.java)
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

        fun clickHotel(){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        fun clickHotelWithCategories(){
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