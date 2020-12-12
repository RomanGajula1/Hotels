package com.example.hotels.hotel.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.hotels.R
import com.example.hotels.category.model.Category
import com.example.hotels.hotel.viewModel.AddHotelViewModel
import kotlinx.android.synthetic.main.task_option.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdapterSpinnerCategory(context: Context) :
    ArrayAdapter<Category>(context, R.layout.task_option), KoinComponent {

    private val addHotelViewModel: AddHotelViewModel by inject()

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }

    override fun getCount(): Int {
        return addHotelViewModel.listCategory!!.size
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layout.inflate(R.layout.task_option, parent, false)

        val category = addHotelViewModel.listCategory!![position]
        view.option.text = category.name.toString()

        return view
    }


}