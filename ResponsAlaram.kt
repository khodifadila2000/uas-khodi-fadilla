package com.informatika19100066.khodifadila.model

import com.google.gson.annotations.SerializedName

data class ResponseActionAlaram(

    @field:SerializedName( "pesan")
    val pesan: String? = null,

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("status")
    val status: Boolean? = null
)

data class DataItem(

    @field:SerializedName("hari")
    val nama_orang: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("jam_mulai")
    val jam_mulai: String? =null,

    @field:SerializedName("jam_berhenti")
    val jam_berhenti: String? =null,

)
