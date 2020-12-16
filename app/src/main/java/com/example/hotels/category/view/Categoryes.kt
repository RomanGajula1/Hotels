package com.example.hotels.category.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.R
import com.example.hotels.city.view.Citys
import com.example.hotels.databinding.ActivityHotelWithCategoriesBinding
import com.example.hotels.hotel.view.MainActivity
import com.example.hotels.category.viewModel.CategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Categoryes : AppCompatActivity() {

    private val categoryViewModel: CategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHotelWithCategoriesBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_hotel_with_categories)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@Categoryes)
            recyclerView.adapter = this@Categoryes.categoryViewModel.adapterCategories
        }

        categoryViewModel.listCategory.observe(this, Observer {
            categoryViewModel.adapterCategories.setDataCategory(it)
        })

    }

    fun clickAddCategory(view: View) {
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