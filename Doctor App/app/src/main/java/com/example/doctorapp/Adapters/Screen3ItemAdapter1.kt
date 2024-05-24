package com.example.doctorapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doctorapp.Activity.Screen3Activity
import com.example.doctorapp.Activity.Screen4Activity
import com.example.doctorapp.Models.Screen1ModelClass
import com.example.doctorapp.Models.Screen3ModelClass1
import com.example.doctorapp.R
import kotlin.random.Random

class Screen3ItemAdapter1(var dataList: ArrayList<Screen3ModelClass1>, var context: Context):RecyclerView.Adapter<Screen3ItemAdapter1.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val sch_time:TextView = view.findViewById(R.id.sch_time)
        val sch_checkup:TextView = view.findViewById(R.id.sch_checkup)
        val cardView:CardView = view.findViewById(R.id.cardView5)
        val cardView1: LinearLayout = view.findViewById(R.id.cardView6)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.screen3item_file1,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val module = dataList[position]

        holder.sch_time.text = module.sch_time
        holder.sch_checkup.text = module.sch_checkup


        holder.cardView1.setOnClickListener {

                val intent = Intent(context, Screen4Activity::class.java)
                context.startActivity(intent)
        }

        //        set random color in background
        holder.cardView.setCardBackgroundColor(holder.itemView.getResources().getColor(randomColor(), null));
    }

    private fun randomColor(): Int {

        val list = ArrayList<Int>()
        list.add(R.color.Color1)
        list.add(R.color.Color2)
        list.add(R.color.Color3)
        list.add(R.color.Color4)
        list.add(R.color.Color5)

        val seed: Long = System.currentTimeMillis()

        val randomIndex = Random(seed).nextInt(list.size)
        return list[randomIndex]

    }
}