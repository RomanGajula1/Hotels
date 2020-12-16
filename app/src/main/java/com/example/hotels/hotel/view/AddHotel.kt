package com.example.hotels.hotel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.hotels.hotel.viewModel.AddHotelViewModel
import com.example.hotels.R
import com.example.hotels.databinding.ActivityAddHotelBinding
import com.example.hotels.hotel.adapter.AdapterSpinnerCategory
import com.example.hotels.hotel.adapter.AdapterSpinnerCity
import kotlinx.android.synthetic.main.activity_add_hotel.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class AddHotel : AppCompatActivity(), KoinComponent {

    private val addHotelViewModel: AddHotelViewModel by viewModel()
    var nameCategory = String()
    var nameCity = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddHotelBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_hotel)

        binding.apply {
            lifecycleOwner = this@AddHotel
            addViewModel = this@AddHotel.addHotelViewModel
        }
        val adapterSpinnerCategory = AdapterSpinnerCategory(this)
        val adapterSpinnerCitys = AdapterSpinnerCity(this)
        spinnerCategory.adapter = adapterSpinnerCategory
        spinnerCity.adapter = adapterSpinnerCitys

        addHotelViewModel.listCity.observe(this, Observer {
            adapterSpinnerCitys.setDataSpinnerCity(it)
        })

        addHotelViewModel.listCategory.observe(this, Observer {
            adapterSpinnerCategory.setDataSpinnerCategory(it)
        })

        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                addHotelViewModel.listCategory.observe(this@AddHotel, Observer {
                    nameCategory = it[position].name.toString()
                })
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                addHotelViewModel.listCity.observe(this@AddHotel, Observer {
                    nameCity = it[position].name.toString()
                })
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    fun clickAddHotel(view: View) {
        if (addName.text.toString() == "" ||
            addDescription.text.toString() == ""
        ) {
            Toast.makeText(
                this,
                "Пожалуйста заполните все поля!",
                Toast.LENGTH_LONG
            ).show()
            when ("") {
                addName.text.toString() -> addName.error = "Введите название отеля!"
                addDescription.text.toString() -> addDescription.error =
                    "Введите описание отеля!"
            }
        } else {
            addHotelViewModel.clickAddHotel(nameCategory, nameCity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Отель добавлен!", Toast.LENGTH_LONG).show()
        }
    }

}