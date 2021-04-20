package com.example.healtyapp.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref(activity: Activity) {

    // deklarasi variabel login shared
    val login = "login"
    val myPref = "MAIN_PRF"
    val sp: SharedPreferences

    init {
        sp = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE) // value activitu
    }

    // function status login
    fun setStatusLogin(status: Boolean) {
        sp.edit().putBoolean(login, status).apply() // validasi database status login
    }

    // function get status boolean
    fun getStatusLogin(): Boolean{
        return sp.getBoolean(login, false) // get database status login
    }

}