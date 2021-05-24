package com.example.healtyapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.healtyapp.R
import com.example.healtyapp.app.ApiConfig
import com.example.healtyapp.model.ResponseModel
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
            register()
        }

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
        ApiConfig.instanceRetrofit.register(edit_nama.text.toString(), edit_email.text.toString(), edit_password.text.toString()).enqueue(object : Callback<ResponseModel>{

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(this@RegisterActivity, "Error : "+t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {

                val respon = response.body()!!

                if (respon.success == 1) {
                    // berhasil
                    Toast.makeText(this@RegisterActivity, "Success : "+"Selamat datang "+respon.user.name, Toast.LENGTH_SHORT).show()
                } else {
                    // gagal
                    Toast.makeText(this@RegisterActivity, "Error : "+respon.message, Toast.LENGTH_SHORT).show()
                }
            }
        })

    }

}