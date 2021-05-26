package com.example.healtyapp.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPref(activity: Activity) {

    // deklarasi variabel login shared
    val login = "login"
    val name = "name"
    val email = "email"
    val phone = "phone"

    val myPref = "MAIN_PRF"
    val sp: SharedPreferences

    init {
        sp = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE) // value activity
    }

    // function status login
    fun setStatusLogin(status: Boolean) {
        sp.edit().putBoolean(login, status).apply()
    }

    // function get status boolean
    fun getStatusLogin(): Boolean{
        return sp.getBoolean(login,false)
    }

    fun setString(key: String, vlaue: String) {
        sp.edit().putString(key, vlaue).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "")!!
    }

}