package com.azuka.retrofitphpapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.azuka.retrofitphpapp.data.*
import com.azuka.retrofitphpapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val myAdapter by lazy { Adapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDatalist.layoutManager = LinearLayoutManager(this)
        binding.rvDatalist.adapter = myAdapter

        val request = RetrofitInstance.buildService(GetDataServices::class.java)
        val call = request.getListData()

        call.enqueue(object : Callback<DataResponse>{
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful){
                    myAdapter.apply {
                        response.body()!!.data
                        notifyDataSetChanged()
                    }
                }
            }
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}