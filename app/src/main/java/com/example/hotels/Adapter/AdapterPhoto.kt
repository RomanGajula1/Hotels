package com.example.hotels.Adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object AdapterPhoto {
    @JvmStatic
    @BindingAdapter("app:image")
    fun loadImage(view: ImageView, url: String) {
        Picasso.get().load(url).into(view)
    }
}