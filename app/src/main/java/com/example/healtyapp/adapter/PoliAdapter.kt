package com.example.healtyapp.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.healtyapp.MainActivity
import com.example.healtyapp.R
import com.example.healtyapp.activity.DokterActivity
import com.example.healtyapp.model.Dokter
import com.example.healtyapp.model.Poli
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class PoliAdapter(var activity: Activity, var data:ArrayList<Poli>):RecyclerView.Adapter<PoliAdapter.Holder>() {

    class Holder(view : View): RecyclerView.ViewHolder(view) {
        // variabel untuk menampung nama gambar dan harga
        val tv_nama = view.findViewById<TextView>(R.id.tv_poli)
        val tv_ruangan = view.findViewById<TextView>(R.id.tv_ruangan)
        val image_poli = view.findViewById<ImageView>(R.id.img_poli)
        val card_poli =view.findViewById<CardView>(R.id.card_poli)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_poli, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        // bagian logika untuk men set value
        holder.tv_nama.text = data[position].name
        holder.tv_ruangan.text  = data[position].ruangan
        //load image
        val image = "http://192.168.43.136/webhealty/public/storage/poli/" + data[position].image
        Picasso.get()
            .load(image)
            .placeholder(R.drawable.poli_tht)
            .into(holder.image_poli)

        holder.card_poli.setOnClickListener {
            val activiti = Intent(activity, DokterActivity::class.java)
            activity.startActivity(activiti)
        }
    }

}