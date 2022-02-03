package com.informatika19100066.khodifadila.network

import com.informatika19100066.khodifadila.adapter.ListContent
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {
    @GET("read.php")
    fun getBarang(): Call<ListContent.ResponActionAlaram>

    @FormUrlEncoded
    @POST("create.php")
    fun insertBarang(
        @Field("hari") nama_orang: String?,
        @Field("jam_masuk")jam_masuk: String?,
        @Field("jam_berhenti")jam_berhenti: String?,
    ): Call<ResponActionAlaram>

    @FormUrlEncoded
    @POST("update.php")
    fun updateBarang(
        @Field("hari") nama_orang: String?,
        @Field("jam_masuk")jam_masuk: String?,
        @Field("jam_berhenti")jam_berhenti: String?,

        @FormUrlEncoded
        @POST("delete.php")
        fun deleteBarang(
    @Field("id") id: String?
    ): Call<responactioninfaq>

    @FormUrlEncoded
    @POST("login.php")
    fun logIn(
        @Field("username") username : String?,
        @Field("password") password : String?
    ):Call<ResponActionAlaram>

    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("username") username : String?,
        @Field("password") password : String?
    ):Call<ResponActionAlaram>

    fun updateBarang(id: String, nama_orang: String, tanggal: String): Call<ResponActionAlaram>
