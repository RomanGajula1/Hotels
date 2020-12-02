package com.example.hotels.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.model.Hotel
import com.example.hotels.viewModel.ListHotelViewModel
import com.example.hotels.R
import com.example.hotels.VIEW.DetailsHotel
import com.squareup.picasso.Picasso
import org.koin.core.KoinComponent
import org.koin.core.inject

@Suppress("DEPRECATION")
class AdapterHotel() :
    RecyclerView.Adapter<AdapterHotel.MyViewHolder>(), KoinComponent {

    val hotelsListViewModel: ListHotelViewModel by inject()

    inner class MyViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val nameHotel: TextView = view.findViewById<View>(R.id.nameHotel) as TextView
        val imageView: ImageView = view.findViewById<View>(R.id.imageHotel) as ImageView
        private val buttonDelete: Button = view.findViewById<View>(R.id.buttonDelete) as Button

        init {
            view.setOnClickListener {
                val intent = Intent(view.context, DetailsHotel::class.java)
                intent.putExtra("id", hotelsListViewModel.hotelList!![bindingAdapterPosition].id)
                view.context.startActivity(intent)
            }

            buttonDelete.setOnClickListener {
                val hotel = Hotel()
                hotel.id = hotelsListViewModel.hotelList!![bindingAdapterPosition].id
                hotelsListViewModel.repository.deleteHotel(hotel)
                Toast.makeText(view.context, "Отель удалён!", Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_hotel, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val itemText = hotelsListViewModel.hotelList!![position]
        holder.nameHotel.text = itemText.name

        Picasso.get()
            .load(hotelsListViewModel.hotelList!![position].image)
            .error(R.drawable.rotate)
            .into(holder.imageView)
    }

    fun setData(hotel: List<Hotel>?) {
        this.hotelsListViewModel.hotelList = hotel
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return hotelsListViewModel.hotelList?.size ?: 0
    }
}