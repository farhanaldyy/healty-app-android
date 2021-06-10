package com.example.healtyapp.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healtyapp.R
import com.example.healtyapp.adapter.DokterAdapter
import com.example.healtyapp.app.ApiConfig
import com.example.healtyapp.model.Dokter
import com.example.healtyapp.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DokterActivity : AppCompatActivity() {

    lateinit var rv_dokter: RecyclerView
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter)

        rv_dokter = findViewById(R.id.rv_dokter)

        getDokter()

    }

    fun displayDokter() {
        rv_dokter.adapter = DokterAdapter(listDokter)
        rv_dokter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
    }

    private var listDokter: ArrayList<Dokter> = ArrayList()
    fun getDokter() {
        ApiConfig.instanceRetrofit.getDokter().enqueue(object : Callback<ResponseModel> {

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                if (res.success == 1){
                    listDokter = res.dokters
                    displayDokter()
                }
            }
        })
    }
}