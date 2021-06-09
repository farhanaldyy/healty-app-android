package com.example.healtyapp.model

class ResponseModel {
    var success = 0
    lateinit var message:String
    var user = User()
    var polis : ArrayList<Poli> = ArrayList()
}