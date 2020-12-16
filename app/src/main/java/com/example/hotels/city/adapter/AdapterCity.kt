package com.example.hotels.city.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.R
import com.example.hotels.category.model.Category
import com.example.hotels.city.view.UpdateCity
import com.example.hotels.city.model.City
import com.example.hotels.city.viewModel.CityViewModel
import com.example.hotels.databinding.TaskCityBinding
import com.example.hotels.databinding.TaskHotelBinding
import com.example.hotels.hotel.model.Hotel
import kotlinx.android.synthetic.main.task_city.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class AdapterCity : RecyclerView.Adapter<AdapterCity.MyViewHolder>(), KoinComponent {

    val cityViewModel: CityViewModel by inject()
    var cityList = emptyList<City>()

    inner class MyViewHolder(val binding: TaskCityBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val city = cityList[bindingAdapterPosition]
            binding.cityViewModel = city
            val view = binding.root
            view.deleteCity.setOnClickListener {
                val hotelCity = City()
                hotelCity.id = city.id
                cityViewModel.deleteCity(hotelCity)

                Toast.makeText(view.context, "Город удалён!", Toast.LENGTH_LONG).show()
            }
            view.buttonUpdateCity.setOnClickListener {
                val hotelCity = City()
                hotelCity.id = city.id
                val intent = Intent(view.context, UpdateCity::class.java)
                intent.putExtra("idCity", city.id)
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = TaskCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
        val items = cityList[position]
        holder.itemView.nameCity.text = items.name
    }

    fun setDataCity(city: List<City>) {
        this.cityList = city
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

}