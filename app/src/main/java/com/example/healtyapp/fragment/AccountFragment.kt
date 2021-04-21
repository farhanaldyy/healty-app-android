package com.example.healtyapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.healtyapp.R
import com.example.healtyapp.helper.SharedPref


class AccountFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btn_logout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate layout this fragment
        val view: View = inflater.inflate(R.layout.fragment_account, container, false)
        btn_logout = view.findViewById(R.id.btn_logout)

        s = SharedPref(requireActivity())

        btn_logout.setOnClickListener {
            s.setStatusLogin(false)
        }

        return view

    }

}