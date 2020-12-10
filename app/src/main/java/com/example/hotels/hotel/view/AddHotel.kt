package com.example.hotels.hotel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.hotel.viewModel.AddHotelViewModel
import com.example.hotels.R
import com.example.hotels.databinding.ActivityAddHotelBinding
import kotlinx.android.synthetic.main.activity_add_hotel.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class AddHotel : AppCompatActivity(), KoinComponent {

    private val addHotelViewModel: AddHotelViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddHotelBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_hotel)

        binding.apply {
            lifecycleOwner = this@AddHotel
            addViewModel = this@AddHotel.addHotelViewModel
        }
    }

    fun clickAddHotel(view: View) {
        if (addCity.text.toString() == "" || addName.text.toString() == "" ||
            addDescription.text.toString() == ""
        ) {
            Toast.makeText(
                this,
                "Пожалуйста заполните все поля!",
                Toast.LENGTH_LONG
            ).show()
            when ("") {
                addName.text.toString() -> addName.error = "Введите название отеля!"
                addDescription.text.toString() -> addDescription.error = "Введите описание отеля!"
                addCity.text.toString() -> addDescription.error = "Введите описание отеля!"
            }
        } else {
            addHotelViewModel.clickAddHotel()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Отель добавлен!", Toast.LENGTH_LONG).show()
        }
    }
}