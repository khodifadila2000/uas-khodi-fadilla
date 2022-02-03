package com.informatika19100066.khodifadila

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.informatika19100066.khodifadila.network.koneksi
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class InsertDataActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)
        val toolbar =

            toolbar.title = "INSERT DATA"
        toolbar.setTitleTextColor(Color.WHITE)

        btn_submit.setOnClickListener {
            val ethari = et_hari.text
            val etJamamulai = et_jam_mulai.text
            val etJamaberhenti = et_jam_berhenti.text
            if (ethari.isEmpty()) {
                Toast.makeText(
                    this@InsertDataActivity,
                    "jam Tidak Boleh Kosong",
                    Toast.LENGTH_LONG
                ).show()
            } else if (ethari.isEmpty()) {
                Toast.makeText(
                    this@InsertDataActivity,
                    "jam Tidak Boleh Kosong",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                val ethari = null
                val etjam_mulai = null
                val etjam_berhenti = null
                actionData(ethari.toString(), etjam_berhenti.toString())
            }
        }

        val btn_clean =


        btn_clean.setOnClickListener {
            formClear()
        }
        getData()
    }

    }

    fun actionData(hari: String, jam_mulai: String,jam_berhenti: String) {
        koneksi.service.insertBarang(hari, jam_mulai,jam_berhenti)
            .enqueue(object : Callback<com.informatika19100066.khodifadila.adapter.ListContent.responactioninfak> {
                override fun onFailure(call: Call<com.informatika19100066.khodifadila.adapter.ListContent.responactioninfak>, t: Throwable) {
                    Log.d("pesan1", t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<com.informatika19100066.khodifadila.adapter.ListContent.responactioninfak>,
                    response: Response<com.informatika19100066.khodifadila.adapter.ListContent.responactioninfak>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            this@InsertDataActivity,
                            "data berhasil disimpan",
                            Toast.LENGTH_LONG
                        ).show()
                        formClear()
                        getData()
                    }
                }
            })
    }

    fun getData() {
        koneksi.service.getBarang().enqueue(object : Callback<responinfak> {
            override fun onFailure(call: Call<responinfak>, t: Throwable) {
                Log.d("pesan1", t.localizedMessage)
            }

            override fun onResponse(
                call: Call<responinfak>,
                response: Response<responinfak>
            ) {
                if (response.isSuccessful) {
                    val dataBody = response.body()
                    val datacontent = dataBody!!.data

                    val rvAdapter = ListContent(datacontent, this@InsertDataActivity, "InsertDataActivity")

                    rv_data_barang.apply {
                        var adapter = rvAdapter
                        var layoutManager = LinearLayoutManager(this@InsertDataActivity)
                    }
                }
            }
        })
    }

    class LinearLayoutManager(insertDataActivity: InsertDataActivity) {

    }

    class ListContent(datacontent: Any, insertDataActivity: InsertDataActivity, s: String) {

    }

    class responinfak {

        val data: Any
            get() {
                TODO()
            }
    }
}

fun <T> Call<T>.enqueue(callback: Callback<InsertDataActivity.responinfak>) {
    TODO("Not yet implemented")
}

