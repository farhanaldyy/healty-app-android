package com.example.healtyapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.healtyapp.R
import com.example.healtyapp.app.ApiConfig
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_register.setOnClickListener{

        }

        register()

    }

    // function validasi field
    fun register() {
        if (edit_nama.text.isEmpty()) {
            edit_nama.error = "Nama tidak boleh kosong"
            edit_nama.requestFocus()
            return
        } else if (edit_email.text.isEmpty()) {
            edit_email.error = "Email tidak boleh kosong"
            edit_email.requestFocus()
            return
        } else if (edit_tlp.text.isEmpty()) {
            edit_tlp.error = "Nomor telpon tidak boleh kosong"
            edit_tlp.requestFocus()
            return
        } else if (edit_password.text.isEmpty()) {
            edit_password.error = "Password tidak boleh kosong"
            edit_password.requestFocus()
            return
        }

        // validasi berhasil -> panggil url api
        ApiConfig.instanceRetrofit.register(edit_nama.text.toString(), edit_email.text.toString(), edit_password.text.toString()).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                // hendel ketika response gagal

            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                // hendel ketika response sukses

            }
        })

    }

}