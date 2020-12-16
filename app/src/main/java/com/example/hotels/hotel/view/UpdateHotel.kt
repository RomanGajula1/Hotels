package com.example.hotels.hotel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.hotels.R
import com.example.hotels.hotel.viewModel.UpdateHotelViewModel
import com.example.hotels.databinding.ActivityUpdateHotelBinding
import com.example.hotels.hotel.adapter.AdapterSpinnerCategory
import com.example.hotels.hotel.adapter.AdapterSpinnerCity
import kotlinx.android.synthetic.main.activity_update_hotel.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class UpdateHotel : AppCompatActivity(), KoinComponent {

    private val updateHotelViewModel: UpdateHotelViewModel by viewModel()
    var idToUpdate: Int = 0
    var nameCategory = String()
    var nameCity = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUpdateHotelBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_update_hotel
        )

        idToUpdate = intent.getIntExtra("idToUpdate", 0)

        updateHotelViewModel.loadForUpdate(idToUpdate)

        binding.apply {
            lifecycleOwner = this@UpdateHotel
            updateHotelViewModel = this@UpdateHotel.updateHotelViewModel
        }

        val adapterSpinnerCategory = AdapterSpinnerCategory(this)
        val adapterSpinnerCitys = AdapterSpinnerCity(this)
        spinnerCategoryUpdate.adapter = adapterSpinnerCategory
        spinnerCityUpdate.adapter = adapterSpinnerCitys

        updateHotelViewModel.listCity.observe(this, Observer {
            adapterSpinnerCitys.setDataSpinnerCity(it)
        })

        updateHotelViewModel.listCategory.observe(this, Observer {
            adapterSpinnerCategory.setDataSpinnerCategory(it)
        })

        spinnerCategoryUpdate.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                updateHotelViewModel.listCategory.observe(this@UpdateHotel, Observer {
                    nameCategory = it[position].name.toString()
                })
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        spinnerCityUpdate.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                updateHotelViewModel.listCity.observe(this@UpdateHotel, Observer {
                    nameCity = it[position].name.toString()
                })
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

    }

    fun clickUpdateHotel(view: View) {
        if (descriptionUpdate.text.toString() == "" ||
            nameUpdate.text.toString() == ""
        ) {
            Toast.makeText(
                this,
                "Пожалуйста заполните все поля!",
                Toast.LENGTH_LONG
            ).show()
            when ("") {
                nameUpdate.text.toString() -> nameUpdate.error = "Введите название отеля!"
                descriptionUpdate.text.toString() -> descriptionUpdate.error =
                    "Введите описание отеля!"
            }
        } else {
            updateHotelViewModel.clickUpdateHotel(idToUpdate, nameCategory, nameCity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Отель обновлён!", Toast.LENGTH_LONG).show()
        }
    }
}