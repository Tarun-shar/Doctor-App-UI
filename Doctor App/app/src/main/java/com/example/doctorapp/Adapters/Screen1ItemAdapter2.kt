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
import com.example.doctorapp.Activity.Screen2Activity
import com.example.doctorapp.Models.Screen1ModelClass2
import com.example.doctorapp.R

class Screen1ItemAdapter2(var dataList: ArrayList<Screen1ModelClass2>, var context: Context):RecyclerView.Adapter<Screen1ItemAdapter2.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val doctor_name:TextView = view.findViewById(R.id.doctor_name)
        val doctor_profile:TextView = view.findViewById(R.id.doctor_profile)
        val doctor_rating:ImageView = view.findViewById(R.id.doctor_rating)
        val doctor_reviews:TextView = view.findViewById(R.id.doctor_review)
        val doctor_image:ImageView = view.findViewById(R.id.image_doctor)

        val cardView:CardView = view.findViewById(R.id.cardView9)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.screen1item_file2,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

       holder.doctor_name.text = module.doctor_name
       holder.doctor_profile.text = module.doctor_profile
        Glide.with(context).load(module.doctor_rating).into(holder.doctor_rating)
        holder.doctor_reviews.text = module.doctor_review
//        holder.doctor_image.setImageResource(module.doctor_image)
        Glide.with(context).load(module.doctor_image).into(holder.doctor_image)

        holder.cardView.setOnClickListener {
            val intent = Intent(context, Screen2Activity::class.java)
            context.startActivity(intent)
        }
    }
}