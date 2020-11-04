package com.azuka.retrofitphpapp.data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("address")
    val address: String,
    @SerializedName("contact")
    val contact: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)