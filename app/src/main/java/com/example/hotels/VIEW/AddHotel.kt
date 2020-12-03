package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.viewModel.AddViewModel
import com.example.hotels.R
import com.example.hotels.databinding.ActivityAddHotelBinding
import kotlinx.android.synthetic.main.activity_add_hotel.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class AddHotel : AppCompatActivity(), KoinComponent {

    private val addViewModel: AddViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddHotelBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_hotel)

        binding.apply {
            lifecycleOwner = this@AddHotel
            addViewModel = this@AddHotel.addViewModel
        }
    }

    fun clickAddHotel(view: View) {
        if (addImages.text.toString() == "" || addName.text.toString() == "" ||
            addDescription.text.toString() == ""
        ) {
            Toast.makeText(
                this,
                "Пожалуйста заполните все поля!",
                Toast.LENGTH_LONG
            ).show()
            when ("") {
                addName.text.toString() -> addName.error = "Введите название отеля!"
                addImages.text.toString() -> addImages.error = "Введите путь к фото отеля!"
                addDescription.text.toString() -> addDescription.error = "Введите описание отеля!"
            }
        } else {
            addViewModel.clickAddHotel()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Отель добавлен!", Toast.LENGTH_LONG).show()
        }
    }
}