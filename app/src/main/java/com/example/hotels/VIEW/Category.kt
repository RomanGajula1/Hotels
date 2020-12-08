package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hotels.R
import com.example.hotels.databinding.ActivityHotelWithCategoriesBinding
import com.example.hotels.viewModel.CategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class Category : AppCompatActivity() {

    private val categoryViewModel: CategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHotelWithCategoriesBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_hotel_with_categories)

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@Category)
            recyclerView.adapter = this@Category.categoryViewModel.adapterCategories
        }
        categoryViewModel.adapterCategories.setDataCategories(categoryViewModel.listCategory!!)
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

        fun clickHotelWithCategories() {
            intent = Intent(this, Category::class.java)
            startActivity(intent)
        }

        fun clickCity() {
            intent = Intent(this, City::class.java)
            startActivity(intent)
        }

        when (id) {
            R.id.hotel -> clickHotel()
            R.id.hotelWithCategories -> clickHotelWithCategories()
            R.id.hotelCity -> clickCity()
        }

        return super.onOptionsItemSelected(item)
    }
}