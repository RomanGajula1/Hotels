package com.example.hotels.hotel.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.hotel.viewModel.ListHotelViewModel
import com.example.hotels.R
import com.example.hotels.hotel.view.DetailsHotel
import com.example.hotels.databinding.TaskHotelBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.task_hotel.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

@Suppress("DEPRECATION")
class AdapterHotel() :
    RecyclerView.Adapter<AdapterHotel.MyViewHolder>(), KoinComponent {

    val hotelsListViewModel: ListHotelViewModel by inject()

    inner class MyViewHolder(val binding: TaskHotelBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val hotel = hotelsListViewModel.hotelList?.get(bindingAdapterPosition)
            binding.modelHotel = hotel
            val view = binding.root
            view.setOnClickListener {
                val intent = Intent(view.context, DetailsHotel::class.java)
                intent.putExtra("id", hotel?.id)
                view.context.startActivity(intent)
            }
            view.buttonDelete.setOnClickListener {
                hotelsListViewModel.deleteHotel(hotel!!)
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
        val itemText = hotelsListViewModel.hotelList!![position]
        val category =
            hotelsListViewModel.getHotelWithCategories(itemText.category!!)
        val city = hotelsListViewModel.getHotelWithCity(itemText.city!!)

        if (itemText.category != 0) {
            holder.itemView.categoryHotel.text =
                category!!.first().categories.category.toString() + " stars, "
            holder.itemView.city.text = city!!.first().city.city.toString()
        } else {
            holder.itemView.categoryHotel.text = city!!.first().city.city.toString()
        }



//        Picasso.get()
//            .load(hotelsListViewModel.hotelList!![position].image)
//            .error(R.drawable.rotate)
//            .into(holder.itemView.imageHotel)
    }

    override fun getItemCount(): Int {
        return hotelsListViewModel.hotelList?.size ?: 0
    }
}