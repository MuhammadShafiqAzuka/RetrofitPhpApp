package com.azuka.retrofitphpapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.azuka.retrofitphpapp.data.DataResponse
import com.azuka.retrofitphpapp.data.GetDataServices
import com.azuka.retrofitphpapp.data.RetrofitInstance
import com.azuka.retrofitphpapp.databinding.ActivityAddBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {
            val name = binding.addName.text.toString()
            val address = binding.addAddress.text.toString()
            val contact = binding.addContact.text.toString()

            when {
                name.trim() == "" -> {
                    binding.addName.error = "Name cannot empty"
                }
                address.trim() == "" -> {
                    binding.addAddress.error = "Address cannot empty"
                }
                contact.trim() == "" -> {
                    binding.addContact.error = "Contact cannot empty"
                }
                else -> {
                    addData(name,address,contact)
                }
            }
        }
    }

    private fun addData(name: String, address: String, contact: String) {
        val request = RetrofitInstance.buildService(GetDataServices::class.java)
        val save = request.addListData(name, address, contact)

        save.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@AddActivity, response.body()!!.message, Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Toast.makeText(this@AddActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
