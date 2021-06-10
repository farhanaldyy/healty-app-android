package com.example.healtyapp.app

import com.example.healtyapp.model.ResponseModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("register") // pull request base url untuk api config
    fun register(
        // isi parameter variabel field
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String
    ):Call<ResponseModel>

    @FormUrlEncoded
    @POST("login") // pull request untuk api config
    fun login(
        // isi parameter variabel field
        @Field("email") email: String,
        @Field("password") password: String
    ):Call<ResponseModel>

    @GET("poli") // pull request untuk api config
    fun getPoli():Call<ResponseModel>

    @GET("dokter")
    fun getDokter():Call<ResponseModel>

}