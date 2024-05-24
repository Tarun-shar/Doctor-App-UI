package com.example.doctorapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctorapp.Activity.Screen3Activity
import com.example.doctorapp.Activity.Screen4Activity
import com.example.doctorapp.Models.Screen1ModelClass2
import com.example.doctorapp.Models.Screen2ModelClass1
import com.example.doctorapp.Models.Screen5ModelClass
import com.example.doctorapp.R

class Screen5ItemAdapter(var dataList: ArrayList<Screen5ModelClass>, var context: Context):RecyclerView.Adapter<Screen5ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val doctor_name2:TextView = view.findViewById(R.id.doctor_name2)
        val doctor_address2:TextView = view.findViewById(R.id.doctor_address2)
        val doctor_number:TextView = view.findViewById(R.id.doctor_number)
        val available_time:TextView = view.findViewById(R.id.available_time)
        val doctor_image2:ImageView = view.findViewById(R.id.image_doctor2)

        val cardView:CardView = view.findViewById(R.id.cardView8)
        var book_now_btn:TextView = view.findViewById(R.id.bookNowBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.screen5item_file,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

       holder.doctor_name2.text = module.doctor_name2
        holder.doctor_address2.text = module.doctor_address2
        holder.doctor_number.text = module.doctor_number
        holder.available_time.text = module.available_time
        holder.doctor_image2.setImageResource(module.doctor_image2)

        holder.book_now_btn.setOnClickListener {
            Toast.makeText(context, "Booked", Toast.LENGTH_SHORT).show()
        }

    }
}