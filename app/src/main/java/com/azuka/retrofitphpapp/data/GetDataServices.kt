package com.azuka.retrofitphpapp.data

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface GetDataServices {
    @GET("retrieve.php")
    fun getListData(): Call<DataResponse>

    @FormUrlEncoded
    @POST("create.php")
    fun addListData(
            @Field("name") name:String,
            @Field("address") address:String,
            @Field("contact") contact:String,
    ): Call<DataResponse>
}