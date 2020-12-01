package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.AddViewModel
import com.example.hotels.R
import com.example.hotels.databinding.ActivityAddHotelBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent

class AddHotel : AppCompatActivity(), KoinComponent {

    private val addViewModel: AddViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddHotelBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_hotel)

//        binding.lifecycleOwner = this
//        binding.addViewModel = addViewModel

        binding.apply {
            lifecycleOwner = this@AddHotel
            addViewModel = this@AddHotel.addViewModel
            buttonAdd.setOnClickListener {
                this@AddHotel.addViewModel.clickAddHotel()
                val intent = Intent(this@AddHotel, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@AddHotel, "Отель добавлен!", Toast.LENGTH_LONG).show()
            }
        }
    }
}