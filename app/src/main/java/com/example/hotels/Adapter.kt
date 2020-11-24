package com.example.hotels

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(var hotelsList: List<Hotel>?) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:image")
        fun loadImage(view: ImageView, url: String) {
            Picasso.get().load(url).into(view)
        }
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) { // MyViewHolder хранит тэги корнегого представления каждого элемента списка.
        val nameHotel: TextView = view.findViewById<View>(R.id.nameHotel) as TextView
        val imageView: ImageView = view.findViewById<View>(R.id.imageHotel) as ImageView
        val imageDelete: ImageView = view.findViewById<View>(R.id.button_delete) as ImageView

//        val hotel = hotelsList?.get(bindingAdapterPosition)?.id

        init {
            view.setOnClickListener {
                val intent = Intent(view.context, DetailsHotel::class.java)
                intent.putExtra("id", hotelsList?.get(bindingAdapterPosition)?.id)
                view.context.startActivity(intent)
            }
            imageDelete.setOnClickListener{
                val hotel = Hotel()
                hotel.id = hotelsList?.get(bindingAdapterPosition)?.id
                Repository().deleteHotel(hotel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_hotel, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { // выполняет привязку объекта, OnBindViewHolder – загружает данные в указанной позиции в представления, ссылки на которые хранятся в заданном заполнителе представления
        val itemText = hotelsList!![position]
        holder.nameHotel.text = itemText.name

        Picasso.get()
            .load(hotelsList!![position].image)
            .error(R.drawable.rotate)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return hotelsList?.size ?: 0
    }
}