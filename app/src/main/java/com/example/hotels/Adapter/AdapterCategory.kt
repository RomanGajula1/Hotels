package com.example.hotels.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.R
import com.example.hotels.VIEW.UpdateCategory
import com.example.hotels.model.HotelCategories
import com.example.hotels.viewModel.CategoryViewModel
import kotlinx.android.synthetic.main.task_category.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdapterCategory : RecyclerView.Adapter<AdapterCategory.MyViewHolder>(), KoinComponent {

    val categoryViewModel: CategoryViewModel by inject()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.deleteCategory.setOnClickListener {
                val hotelCategories = HotelCategories()
                hotelCategories.id = categoryViewModel.listCategory!![bindingAdapterPosition].id
                categoryViewModel.repositoryCategory.deleteCategory(hotelCategories)
                Toast.makeText(view.context, "Категория удалена!", Toast.LENGTH_LONG).show()
            }
            view.updateCategory.setOnClickListener {
                val hotelCategories = HotelCategories()
                hotelCategories.id = categoryViewModel.listCategory!![bindingAdapterPosition].id
                val intent = Intent(view.context, UpdateCategory::class.java)
                intent.putExtra(
                    "idCategory",
                    categoryViewModel.listCategory!![bindingAdapterPosition].id
                )
                view.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_category, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemText = categoryViewModel.listCategory!![position]
        holder.itemView.nameHotelAndWithCategory.text =
            itemText.category.toString() + " - звёздочный."
    }

    fun setDataCategories(hotelCategories: List<HotelCategories>) {
        this.categoryViewModel.listCategory = hotelCategories
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return categoryViewModel.listCategory?.size ?: 0
    }

}