package com.example.hotels.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.R
import com.example.hotels.model.HotelCity
import com.example.hotels.viewModel.CityViewModel   
import kotlinx.android.synthetic.main.task_city.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdapterCity : RecyclerView.Adapter<AdapterCity.MyViewHolder>(), KoinComponent {

    val cityViewModel: CityViewModel by inject()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.deleteCity.setOnClickListener {
                val hotelCity = HotelCity()
                hotelCity.idCity = cityViewModel.listCity[bindingAdapterPosition].idCity
                cityViewModel.repositoryCity.deleteCity(hotelCity)
                Toast.makeText(view.context, "Город удалён!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_city, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items = cityViewModel.listCity[position]
        holder.itemView.nameCity.text = items.city
    }

    fun setDataCity(hotelCity: List<HotelCity>) {
        this.cityViewModel.listCity = hotelCity
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cityViewModel.listCity.size
    }

}