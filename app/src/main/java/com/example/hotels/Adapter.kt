package com.example.hotels

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.hotels.VIEW.DetailsHotel
import com.example.hotels.VIEW.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*

@Suppress("DEPRECATION")
class Adapter(var hotelsList: LiveData<List<Hotel>?>?) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var position: Int? = null
    val repository = Repository()
    val context: Context = MainActivity()

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
        private val imageDelete: ImageView = view.findViewById<View>(R.id.button_delete) as ImageView

        init {
            view.setOnClickListener {
                val intent = Intent(view.context, DetailsHotel::class.java)
                intent.putExtra("id", hotelsList?.value?.get(position)?.id)
                view.context.startActivity(intent)
            }
            imageDelete.setOnClickListener{
                val hotel = Hotel()
                hotel.id = hotelsList?.value?.get(position)?.id
                repository.deleteHotel(hotel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_hotel, parent, false)
        return MyViewHolder(itemsView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { // выполняет привязку объекта, OnBindViewHolder – загружает данные в указанной позиции в представления, ссылки на которые хранятся в заданном заполнителе представления
        val itemText = hotelsList?.value?.get(position)
        holder.nameHotel.text = itemText?.name

        this.position = position

        Picasso.get()
            .load(hotelsList?.value?.get(position)?.image)
            .error(R.drawable.rotate)
            .into(holder.imageView)
    }

    fun setData(hotel: LiveData<List<Hotel>?>?){
        this.hotelsList = hotel
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return hotelsList?.value?.size ?: 0
    }
}