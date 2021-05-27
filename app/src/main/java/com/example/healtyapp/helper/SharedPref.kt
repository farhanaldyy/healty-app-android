package com.example.healtyapp.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.healtyapp.model.User
import com.google.gson.Gson

class SharedPref(activity: Activity) {

    // deklarasi variabel login shared
    val login = "login"
    val name = "name"
    val email = "email"
    val phone = "phone"

    val user = "user"

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

    fun setUser(value: User) {
        val data = Gson().toJson(value, User::class.java)
        sp.edit().putString(user, data).apply()
    }

    fun getUser() : User? {
        val data = sp.getString(user, null)?: return null
        return Gson().fromJson<User>(data, User::class.java)
    }

    fun setString(key: String, vlaue: String) {
        sp.edit().putString(key, vlaue).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "")!!
    }

}