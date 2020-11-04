package com.azuka.retrofitphpapp.data

import retrofit2.Call
import retrofit2.http.GET

interface GetDataServices {
    @GET("retrieve.php")
    fun getListData(): Call<DataResponse>
}