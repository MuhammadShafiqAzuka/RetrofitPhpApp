package com.azuka.retrofitphpapp.data

import retrofit2.Call

class DataRepository(private val dataDAO: GetDataServices) {
    val readAllData: Call<DataResponse> = dataDAO.getListData()
}