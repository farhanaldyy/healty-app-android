package com.example.healtyapp.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.healtyapp.R
import com.example.healtyapp.MainActivity
import com.example.healtyapp.activity.LoginActivity
import com.example.healtyapp.helper.SharedPref


class AccountFragment : Fragment() {

    lateinit var s:SharedPref
    lateinit var btn_logout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate layout this fragment
        return inflater.inflate(R.layout.fragment_poli, container, false)
    }

}