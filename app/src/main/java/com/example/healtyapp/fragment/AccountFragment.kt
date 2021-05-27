package com.example.healtyapp.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.healtyapp.R
import com.example.healtyapp.activity.LoginActivity
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
        // jika data null akan mengarah ke login
        if (s.getUser() == null) {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            return
        }

        // jika data tidak null, data akan di get pada objek sp get user
        val user = s.getUser()!!

        tvNama.text = user.name
        tvEmail.text = user.email
        tvPhone.text = user.phone
    }

    private fun init(view: View) {
        btn_logout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvEmail = view.findViewById(R.id.tv_email)
        tvPhone = view.findViewById(R.id.tv_phone)
    }

}