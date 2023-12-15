package com.example.ecomarket.tools

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.showImage(img: String?) {
    Picasso.get()
        .load(img)
        .into(this)
}