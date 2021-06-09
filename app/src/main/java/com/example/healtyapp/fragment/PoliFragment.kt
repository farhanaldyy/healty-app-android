package com.example.healtyapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.healtyapp.R
import com.example.healtyapp.adapter.PoliAdapter
import com.example.healtyapp.app.ApiConfig
import com.example.healtyapp.model.Poli
import com.example.healtyapp.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PoliFragment : Fragment() {

    lateinit var rvPoli: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =  inflater.inflate(R.layout.fragment_poli, container, false)
        rvPoli = view.findViewById(R.id.rv_poli)

        getPoli()
        return view
    }

    fun displayPoli() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvPoli.adapter = PoliAdapter(listPoli)
        rvPoli.layoutManager = layoutManager
    }

//     variabel baru untuk menampung data array pada halaman poli
    private var listPoli: ArrayList<Poli> = ArrayList()
    fun getPoli() {
        ApiConfig.instanceRetrofit.getPoli().enqueue(object : Callback<ResponseModel> {

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                val res = response.body()!!
                if (res.success == 1){
                    listPoli = res.polis
                    displayPoli()
                }
            }
        })
    }

}