package com.example.hotels.city.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.R
import com.example.hotels.city.view.UpdateCity
import com.example.hotels.city.model.City
import com.example.hotels.city.viewModel.CityViewModel
import kotlinx.android.synthetic.main.task_city.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdapterCity : RecyclerView.Adapter<AdapterCity.MyViewHolder>(), KoinComponent {

    val cityViewModel: CityViewModel by inject()

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.deleteCity.setOnClickListener {
                val hotelCity = City()
                hotelCity.id = cityViewModel.listCity[bindingAdapterPosition].id
                cityViewModel.deleteCity(hotelCity)

                Toast.makeText(view.context, "Город удалён!", Toast.LENGTH_LONG).show()
            }
            view.buttonUpdateCity.setOnClickListener {
                val hotelCity = City()
                hotelCity.id = cityViewModel.listCity[bindingAdapterPosition].id
                val intent = Intent(view.context, UpdateCity::class.java)
                intent.putExtra("idCity", cityViewModel.listCity[bindingAdapterPosition].id)
                view.context.startActivity(intent)
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
        holder.itemView.nameCity.text = items.name
    }

    fun setDataCity(city: List<City>) {
        this.cityViewModel.listCity = city
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cityViewModel.listCity.size
    }

}