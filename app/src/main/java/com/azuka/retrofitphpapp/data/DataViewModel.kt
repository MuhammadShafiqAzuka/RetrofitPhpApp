package com.azuka.retrofitphpapp.data

import androidx.lifecycle.ViewModel
import retrofit2.Call

class DataViewModel(private val repository: DataRepository): ViewModel() {
    val readAllData: Call<DataResponse> = repository.readAllData
}