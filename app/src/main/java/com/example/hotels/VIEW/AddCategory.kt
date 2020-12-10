package com.example.hotels.VIEW

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.R
import com.example.hotels.databinding.ActivityAddCategoryBinding
import com.example.hotels.viewModel.CategoryViewModel
import kotlinx.android.synthetic.main.activity_add_category.*
import kotlinx.android.synthetic.main.activity_add_hotel.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddCategory : AppCompatActivity() {

    private val categoryViewModel: CategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddCategoryBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_add_category)

        binding.apply {
            lifecycleOwner = this@AddCategory
            categoryViewModel = this@AddCategory.categoryViewModel
        }
    }

    fun clickAddCategories(view: View) {
        if (addCategoryToDB.text.toString() == "") {
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
            categoryViewModel.insertCategory()
            val intent = Intent(this, Categoryes::class.java)
            startActivity(intent)
            Toast.makeText(this, "Категория добавленна!", Toast.LENGTH_LONG).show()
        }
    }

}