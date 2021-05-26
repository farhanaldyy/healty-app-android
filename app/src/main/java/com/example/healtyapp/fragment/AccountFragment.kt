package com.example.healtyapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.healtyapp.R
import com.example.healtyapp.helper.SharedPref


class AccountFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btn_logout: Button
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate layout this fragment
        val view: View = inflater.inflate(R.layout.fragment_account, container, false)
        init(view)

        s = SharedPref(requireActivity())

        btn_logout.setOnClickListener {
            s.setStatusLogin(false)
        }

        setData()

        return view

    }

    fun setData() {
        tvNama.text = s.getString(s.name)
        tvEmail.text = s.getString(s.email)
        tvPhone.text = s.getString(s.phone)
    }

    private fun init(view: View) {
        btn_logout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
    }

}