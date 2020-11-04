package com.azuka.retrofitphpapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azuka.retrofitphpapp.data.Data
import retrofit2.Call


class Adapter : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var dataList = emptyList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.data_list, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtId.text = dataList[position].id.toString()
        holder.txtName.text = dataList[position].name
        holder.txtAddress.text = dataList[position].address
        holder.txtContact.text = dataList[position].contact
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtId: TextView = itemView.findViewById(R.id.txt_id)
        var txtName: TextView = itemView.findViewById(R.id.txt_name)
        var txtAddress: TextView = itemView.findViewById(R.id.txt_address)
        var txtContact: TextView = itemView.findViewById(R.id.txt_contact)
    }
}