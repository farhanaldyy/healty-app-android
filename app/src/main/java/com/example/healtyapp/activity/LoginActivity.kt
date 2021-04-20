package com.example.healtyapp.activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.healtyapp.R
import com.example.healtyapp.helper.SharedPref
import com.example.healtyapp.MainActivity

class LoginActivity : AppCompatActivity() {

    // inisialisasi
    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

}