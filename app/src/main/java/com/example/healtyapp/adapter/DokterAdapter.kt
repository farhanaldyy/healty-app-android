package com.example.healtyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.healtyapp.R
import com.example.healtyapp.model.Dokter
import com.squareup.picasso.Picasso

class DokterAdapter(var data: ArrayList<Dokter>): RecyclerView.Adapter<DokterAdapter.Holder>() {

    class Holder(view : View): RecyclerView.ViewHolder(view) {
        // variabel untuk menampung nama dan gambar
        val tv_nama = view.findViewById<TextView>(R.id.tv_dokter)
        val tv_spesialis = view.findViewById<TextView>(R.id.tv_spesialis)
        val image_dokter = view.findViewById<ImageView>(R.id.img_dokter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_dokter, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // bagian logika untuk men set value
        holder.tv_nama.text = data[position].name
        holder.tv_spesialis.text  = data[position].spesialis
        //load image
        val image = "http://192.168.43.136/webhealty/public/storage/dokter/" + data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.poli_tht)
            .into(holder.image_dokter)
    }

}