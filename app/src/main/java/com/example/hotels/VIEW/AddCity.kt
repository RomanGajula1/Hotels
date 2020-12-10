package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.R
import com.example.hotels.databinding.ActivityAddCityBinding
import com.example.hotels.viewModel.CityViewModel
import kotlinx.android.synthetic.main.activity_add_city.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddCity : AppCompatActivity() {
    val cityViewModel: CityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddCityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_city)

        binding.apply {
            lifecycleOwner = this@AddCity
            cityViewModel = this@AddCity.cityViewModel
        }

    }

    fun AddCity(view: View) {
        if (addCity.text.toString() == "") {
            Toast.makeText(
                this,
                "Пожалуйста введите город!",
                Toast.LENGTH_LONG
            ).show()
        } else {
            cityViewModel.insertCity()
            val intent = Intent(this, Citys::class.java)
            startActivity(intent)
            Toast.makeText(this, "Город добавлен!", Toast.LENGTH_LONG).show()
        }
    }
}