package com.azuka.retrofitphpapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azuka.retrofitphpapp.data.Data
import com.azuka.retrofitphpapp.data.DataResponse
import com.azuka.retrofitphpapp.data.GetDataServices
import com.azuka.retrofitphpapp.data.RetrofitInstance
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

        //binding adapter
        binding.rvDatalist.layoutManager = LinearLayoutManager(this)
        binding.rvDatalist.adapter = myAdapter

        //binding buttons
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        binding.swipeLayout.setOnRefreshListener {
            binding.swipeLayout.isRefreshing = true
            postData()
            binding.swipeLayout.isRefreshing = false
        }
    }

    override fun onResume() {
        super.onResume()
        //Retrieve Data From MyPhpAdmin
        postData()
    }

    private fun postData() {
        val request = RetrofitInstance.buildService(GetDataServices::class.java)
        val call = request.getListData()

        call.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful) {
                    generateNoticeList(response.body()!!.data)
                }
            }
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun generateNoticeList(data: List<Data>) {
        myAdapter.setData(data)
    }
}