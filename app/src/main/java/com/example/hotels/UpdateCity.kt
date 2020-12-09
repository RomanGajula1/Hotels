package com.example.hotels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.VIEW.Category
import com.example.hotels.VIEW.City
import com.example.hotels.databinding.ActivityUpdateCategoryBinding
import com.example.hotels.databinding.ActivityUpdateCityBinding
import com.example.hotels.viewModel.UpdateCategoryViewModel
import com.example.hotels.viewModel.UpdateCityViewModel
import kotlinx.android.synthetic.main.activity_update_category.*
import kotlinx.android.synthetic.main.activity_update_city.*
import org.koin.android.ext.android.inject

class UpdateCity : AppCompatActivity() {

    private val updateCityViewModel: UpdateCityViewModel by inject()
    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUpdateCityBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_update_city
        )
        id = intent.getIntExtra("idCity", 0)

        updateCityViewModel.loadForUpdateCity(id)

        binding.apply {
            lifecycleOwner = this@UpdateCity
            updateCityViewModel = this@UpdateCity.updateCityViewModel
        }
    }

    fun clickUpdateCity(view: View) {
        if (updateCity.text.toString() == "") {
            Toast.makeText(
                this,
                "Пожалуйста заполните поле!",
                Toast.LENGTH_LONG
            ).show()
        } else {
            updateCityViewModel.clickUpdateCity(id)
            val intent = Intent(this, City::class.java)
            startActivity(intent)
            Toast.makeText(this, " Город обнавлён!", Toast.LENGTH_LONG).show()
        }
    }

}