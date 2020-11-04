package com.azuka.retrofitphpapp.data


import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String
)