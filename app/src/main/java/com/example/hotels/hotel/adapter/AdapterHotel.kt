package com.example.hotels.hotel.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.hotel.viewModel.ListHotelViewModel
import com.example.hotels.R
import com.example.hotels.category.model.relation.HotelWithCategory
import com.example.hotels.city.model.relation.HotelWithCity
import com.example.hotels.hotel.view.DetailsHotel
import com.example.hotels.databinding.TaskHotelBinding
import com.example.hotels.hotel.model.Hotel
import com.example.hotels.hotel.view.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.task_hotel.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

@Suppress("DEPRECATION")
class AdapterHotel() :
    RecyclerView.Adapter<AdapterHotel.MyViewHolder>(), KoinComponent {

    val hotelsListViewModel: ListHotelViewModel by inject()
    var hotelList = emptyList<Hotel>()
    private var nameCategory: String? = null
    private var nameCity: String? = null
    var hotelWithCategories = emptyList<HotelWithCategory>()
    var hotelWithCity = emptyList<HotelWithCity>()
    var context = MainActivity()

    inner class MyViewHolder(val binding: TaskHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val hotel = hotelList[bindingAdapterPosition]
            binding.modelHotel = hotel
            val view = binding.root
            view.setOnClickListener {
                val intent = Intent(view.context, DetailsHotel::class.java)
                intent.putExtra("id", hotel.id)
                view.context.startActivity(intent)
            }
            view.buttonDelete.setOnClickListener {
                hotelsListViewModel.deleteHotel(hotel)
                hotelsListViewModel.adapter.notifyDataSetChanged()
                Toast.makeText(view.context, "Отель удалён!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = TaskHotelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemsView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bind()
        val itemText = hotelList[position]

        hotelsListViewModel.getHotelWithCategories(itemText.category.toString())
            .observe(context, Observer {
                holder.itemView.categoryWithHotel.text = it.first().category.name + ", "
            })

        hotelsListViewModel.getHotelWithCity(itemText.city.toString()).observe(context, Observer {
            holder.itemView.cityWithHotel.text = it.first().city.name

        })

        if (itemText.image != "") {
            Picasso.get()
                .load(itemText.image)
                .error(R.drawable.rotate)
                .into(holder.itemView.imageHotel)
        }
    }

    fun setDataHotel(hotel: List<Hotel>) {
        this.hotelList = hotel
        notifyDataSetChanged()
    }

    fun setDataHotelWithCategory(hotelWithCategories: List<HotelWithCategory>) {
        this.hotelWithCategories = hotelWithCategories
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return hotelList.size
    }
}