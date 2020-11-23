package com.example.hotels

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(var hotelsList: ArrayList<Hotel>?) : RecyclerView.Adapter<Adapter.MyViewHolder>(){

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
        val buttonDelete: ImageView = view.findViewById<View>(R.id.button_delete) as ImageView

//        private val hotel = hotelsList?.get(bindingAdapterPosition) as Model
//
//        init {
//            view.setOnClickListener{
//                val intent = Intent(view.context, DetailsHotel::class.java)
//                intent.putExtra("id", hotel.id)
//                view.context.startActivity(intent)
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_hotel, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { // выполняет привязку объекта, OnBindViewHolder – загружает данные в указанной позиции в представления, ссылки на которые хранятся в заданном заполнителе представления
        val itemText: Hotel = hotelsList!![position]
        holder.nameHotel.text = itemText.name

//        Picasso.get()
//            .load(hotelsList!![position].image)
//            .error(R.drawable.rotate)
//            .into(holder.imageView)

//        holder.nameHotel.setOnClickListener{
//            val intent = Intent(context.applicationContext, DetailsHotel::class.java)
//            intent.putExtra("id", holder.nameHotel.text)
//            context.startActivity(intent)
        }

    override fun getItemCount(): Int {
        return hotelsList?.size ?: 0
    }
}