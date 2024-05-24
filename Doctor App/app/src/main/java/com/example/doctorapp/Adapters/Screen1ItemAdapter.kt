package com.example.doctorapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctorapp.Models.Screen1ModelClass
import com.example.doctorapp.R

class Screen1ItemAdapter(var dataList: ArrayList<Screen1ModelClass>, var context: Context):RecyclerView.Adapter<Screen1ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val name:TextView = view.findViewById(R.id.name)
        val medicine_name:TextView = view.findViewById(R.id.medicine_name)
        val profession:TextView = view.findViewById(R.id.profession)
        val rate:ImageView = view.findViewById(R.id.rate)
        val rating:TextView = view.findViewById(R.id.rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.screen1item_file,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

        holder.name.text = module.name
        holder.medicine_name.text = module.medicine_name
        holder.profession.text = module.profession
        Glide.with(context).load(module.rate).into(holder.rate)
        holder.rating.text = module.rating
    }
}