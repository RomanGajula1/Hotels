package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.R
import com.example.hotels.viewModel.UpdateViewModel
import com.example.hotels.databinding.ActivityUpdateHotelBinding
import kotlinx.android.synthetic.main.activity_update_hotel.*
import kotlinx.android.synthetic.main.task_hotel.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class UpdateHotel : AppCompatActivity(), KoinComponent {

    private val updateViewModel: UpdateViewModel by viewModel()
    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUpdateHotelBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_update_hotel
        )

        id = intent.getIntExtra("idToUpdate", 0)

        updateViewModel.loadForUpdate(id)

        binding.apply {
            lifecycleOwner = this@UpdateHotel
            updateViewModel = this@UpdateHotel.updateViewModel
        }
    }

    fun clickUpdateHotel(view: View) {
        if (cityUpdate.text.toString() == "" || imageUpdate.text.toString() == "" || descriptionUpdate.text.toString() == "" ||
            nameUpdate.text.toString() == ""
        ) {
            Toast.makeText(
                this,
                "Пожалуйста заполните все поля!",
                Toast.LENGTH_LONG
            ).show()
            when ("") {
                nameUpdate.text.toString() -> nameUpdate.error = "Введите название отеля!"
                imageUpdate.text.toString() -> imageUpdate.error = "Введите путь к фото отеля!"
                cityUpdate.text.toString() -> city.error = "Введите путь к фото отеля!"
                descriptionUpdate.text.toString() -> descriptionUpdate.error =
                    "Введите описание отеля!"
            }
        } else {
            updateViewModel.clickUpdateHotel(id)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Отель обновлён!", Toast.LENGTH_LONG).show()
        }
    }
}