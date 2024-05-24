package com.example.doctorapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorapp.Adapters.Screen1ItemAdapter
import com.example.doctorapp.Adapters.Screen1ItemAdapter2
import com.example.doctorapp.Adapters.Screen4ItemAdapter1
import com.example.doctorapp.Models.Screen1ModelClass
import com.example.doctorapp.Models.Screen1ModelClass2
import com.example.doctorapp.Models.Screen4ModelClass1
import com.example.doctorapp.R
import com.example.doctorapp.databinding.ActivityScreen4Binding

class Screen4Activity : AppCompatActivity() {

    lateinit var binding: ActivityScreen4Binding
    lateinit var adapterObj: Screen4ItemAdapter1
    lateinit var dataList: ArrayList<Screen4ModelClass1>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setDataInRecyclerView()

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setDataInRecyclerView() {
        dataList = ArrayList()

        dataList.add(Screen4ModelClass1(R.color.skyblue,"Eleanor Fant","17 June 2020","09:00 AM"))
        dataList.add(Screen4ModelClass1(R.color.light_pink,"Douglas Lyphe","18 June 2020","10:30 AM"))
        dataList.add(Screen4ModelClass1(R.color.pink,"Hilary Ouse","19 June 2020","02:00 PM"))
        dataList.add(Screen4ModelClass1(R.color.GREY,"Pelican Steve","20 June 2020","05:00 PM"))

        adapterObj = Screen4ItemAdapter1(dataList,this)
        binding.recyclerView4.layoutManager = LinearLayoutManager(this)
        binding.recyclerView4.adapter = adapterObj
    }
}