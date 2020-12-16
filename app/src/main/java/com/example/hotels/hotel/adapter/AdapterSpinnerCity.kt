package com.example.hotels.hotel.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.hotels.R
import com.example.hotels.city.model.City
import kotlinx.android.synthetic.main.task_option.view.*
import org.koin.core.KoinComponent

class AdapterSpinnerCity(var contextAddHotel: Context?) :
    ArrayAdapter<City>(contextAddHotel!!, R.layout.task_option),
    KoinComponent {

    var cityList = emptyList<City>()

    override fun getCount(): Int {
        return cityList.size
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layout.inflate(R.layout.task_option, parent, false)

        val city = cityList[position]
        view.option.text = city.name

        return view
    }

    fun setDataSpinnerCity(city: List<City>) {
        this.cityList = city
        notifyDataSetChanged()
    }
}