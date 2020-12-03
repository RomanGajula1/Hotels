package com.example.hotels.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.HotelAndCategory
import com.example.hotels.R
import com.example.hotels.model.HotelCategories
import com.example.hotels.viewModel.CategoryViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdapterCategory : RecyclerView.Adapter<AdapterCategory.MyViewHolder>(), KoinComponent {

    val categoryViewModel: CategoryViewModel by inject()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameHotelAndWithCategory: TextView =
            view.findViewById<View>(R.id.nameHotelAndWithCategory) as TextView
        private val deleteCategory: Button = view.findViewById<View>(R.id.deleteCategory) as Button

        init {
            deleteCategory.setOnClickListener {
                val hotelCategories = HotelCategories()
                hotelCategories.id = categoryViewModel.listCategory!![bindingAdapterPosition].id
                categoryViewModel.repositoryCategory.deleteCategory(hotelCategories)
                Toast.makeText(view.context, "Категория удалена!", Toast.LENGTH_LONG).show()
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
        holder.nameHotelAndWithCategory.text = itemText.category.toString() + " - звёздочный."
    }

    fun setDataCategories(hotelCategories: List<HotelAndCategory>) {
        this.categoryViewModel.listHotelWithCategory = hotelCategories
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return categoryViewModel.listCategory?.size ?: 0
    }

}