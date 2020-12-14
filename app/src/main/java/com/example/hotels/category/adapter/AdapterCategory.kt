package com.example.hotels.category.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.R
import com.example.hotels.category.view.UpdateCategory
import com.example.hotels.category.model.Category
import com.example.hotels.category.viewModel.CategoryViewModel
import com.example.hotels.databinding.TaskCategoryBinding
import kotlinx.android.synthetic.main.task_category.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdapterCategory : RecyclerView.Adapter<AdapterCategory.MyViewHolder>(), KoinComponent {

    val categoryViewModel: CategoryViewModel by inject()

    inner class MyViewHolder(val binding: TaskCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val category = categoryViewModel.listCategory!![bindingAdapterPosition]
            binding.categoryViewModel = category
            val view = binding.root
            view.deleteCategory.setOnClickListener {
                val hotelCategories = Category()
                hotelCategories.id = category.id
                categoryViewModel.deleteCategory(hotelCategories)
                Toast.makeText(view.context, "Категория удалена!", Toast.LENGTH_LONG).show()
            }
            view.updateCategory.setOnClickListener {
                val hotelCategories = Category()
                hotelCategories.id = category.id
                val intent = Intent(view.context, UpdateCategory::class.java)
                intent.putExtra(
                    "idCategory",
                    category.id
                )
                view.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = TaskCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemsView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
        val itemText = categoryViewModel.listCategory!![position]
        holder.itemView.nameHotelAndWithCategory.text =
            itemText.name.toString()
    }

    fun setDataCategories(categories: List<Category>) {
        this.categoryViewModel.listCategory = categories
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return categoryViewModel.listCategory?.size ?: 0
    }

}