package com.example.hotels.hotel.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.hotels.R
import com.example.hotels.category.model.Category
import kotlinx.android.synthetic.main.task_option.view.*
import org.koin.core.KoinComponent

class AdapterSpinnerCategory(var contextAddHotel: Context?) :
    ArrayAdapter<Category>(contextAddHotel!!, R.layout.task_option), KoinComponent {

    var listCategory = emptyList<Category>()

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }

    override fun getCount(): Int {
        return listCategory.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layout.inflate(R.layout.task_option, parent, false)

        val category = listCategory[position]
        view.option.text = category.name.toString()

        return view
    }

    fun setDataSpinnerCategory(category: List<Category>) {
        this.listCategory = category
        notifyDataSetChanged()
    }

}