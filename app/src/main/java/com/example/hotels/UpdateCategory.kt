package com.example.hotels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hotels.VIEW.Category
import com.example.hotels.VIEW.MainActivity
import com.example.hotels.databinding.ActivityUpdateCategoryBinding
import com.example.hotels.databinding.ActivityUpdateHotelBinding
import com.example.hotels.viewModel.UpdateCategoryViewModel
import kotlinx.android.synthetic.main.activity_update_category.*
import kotlinx.android.synthetic.main.activity_update_hotel.*
import kotlinx.android.synthetic.main.task_hotel.*
import org.koin.android.ext.android.inject

class UpdateCategory : AppCompatActivity() {

    private val updateCategoryViewModel: UpdateCategoryViewModel by inject()
    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUpdateCategoryBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_update_category
        )

        id = intent.getIntExtra("idCategory", 0)

        updateCategoryViewModel.loadForUpdateCategory(id)

        binding.apply {
            lifecycleOwner = this@UpdateCategory
            updateCategoryViewModel = this@UpdateCategory.updateCategoryViewModel
        }
    }

    fun clickUpdateCategory(view: View) {
        if (editUpdateCategory.text.toString() == "") {
            Toast.makeText(
                this,
                "Пожалуйста поле!",
                Toast.LENGTH_LONG
            ).show()
        } else {
            updateCategoryViewModel.clickUpdateCategory(id)
            val intent = Intent(this, Category::class.java)
            startActivity(intent)
            Toast.makeText(this, "Категория обнавлена!", Toast.LENGTH_LONG).show()
        }
    }

}