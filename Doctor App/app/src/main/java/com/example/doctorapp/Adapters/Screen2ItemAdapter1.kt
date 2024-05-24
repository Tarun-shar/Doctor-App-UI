package com.example.doctorapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctorapp.Activity.Screen3Activity
import com.example.doctorapp.Activity.Screen4Activity
import com.example.doctorapp.Models.Screen1ModelClass2
import com.example.doctorapp.Models.Screen2ModelClass1
import com.example.doctorapp.R

class Screen2ItemAdapter1(var dataList: ArrayList<Screen2ModelClass1>, var context: Context):RecyclerView.Adapter<Screen2ItemAdapter1.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val doctor_name1:TextView = view.findViewById(R.id.doctor_name1)
        val doctor_profile1:TextView = view.findViewById(R.id.doctor_profile1)
        val doctor_rating1:TextView = view.findViewById(R.id.doctor_rating1)
        val doctor_rate1:ImageView = view.findViewById(R.id.doctor_rate1)
        val doctor_address:TextView = view.findViewById(R.id.doctor_address)
        val doctor_image1:ImageView = view.findViewById(R.id.image_doctor1)

        val cardView:CardView = view.findViewById(R.id.cardView2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.screen2item_file1,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

        holder.doctor_name1.text = module.doctor_name1
        holder.doctor_profile1.text = module.doctor_profile1
        holder.doctor_rating1.text = module.doctor_rating1
        holder.doctor_address.text = module.doctor_address

        Glide.with(context).load(module.doctor_rate1).into(holder.doctor_rate1)
//        holder.doctor_image1.setImageResource(module.doctor_image1)
        Glide.with(context).load(module.doctor_image1).into(holder.
        doctor_image1)

        holder.cardView.setOnClickListener {
            val intent = Intent(context, Screen3Activity::class.java)
            context.startActivity(intent)
        }

    }
}