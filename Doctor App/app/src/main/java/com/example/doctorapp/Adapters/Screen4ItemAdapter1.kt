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
import com.example.doctorapp.Activity.Screen5Activity
import com.example.doctorapp.Models.Screen1ModelClass
import com.example.doctorapp.Models.Screen4ModelClass1
import com.example.doctorapp.R

class Screen4ItemAdapter1(var dataList: ArrayList<Screen4ModelClass1>, var context: Context):RecyclerView.Adapter<Screen4ItemAdapter1.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val patient_img:ImageView = view.findViewById(R.id.patient_image)
        val patient_name:TextView = view.findViewById(R.id.patient_name)
        val app_date:TextView = view.findViewById(R.id.app_date)
        val app_time:TextView = view.findViewById(R.id.app_time)
        val card_View:CardView = view.findViewById(R.id.cardView7)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.screen4item_file1,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

       holder.patient_img.setImageResource(module.patient_img)
        holder.patient_name.text = module.patient_name
        holder.app_date.text = module.app_date
        holder.app_time.text = module.app_time

        holder.card_View.setOnClickListener {
            val intent = Intent(context, Screen5Activity::class.java)
            context.startActivity(intent)
        }
    }
}