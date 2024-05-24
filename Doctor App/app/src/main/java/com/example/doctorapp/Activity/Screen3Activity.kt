package com.example.doctorapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorapp.Adapters.Screen2ItemAdapter1
import com.example.doctorapp.Adapters.Screen3ItemAdapter1
import com.example.doctorapp.Models.Screen2ModelClass1
import com.example.doctorapp.Models.Screen3ModelClass1
import com.example.doctorapp.R
import com.example.doctorapp.databinding.ActivityScreen3Binding

class Screen3Activity : AppCompatActivity() {

    lateinit var binding:ActivityScreen3Binding

    lateinit var adapterObj: Screen3ItemAdapter1
    lateinit var dataList: ArrayList<Screen3ModelClass1>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setDataInRecyclerView()

        binding.back.setOnClickListener {
            onBackPressed()
        }

    }

    private fun setDataInRecyclerView() {
        dataList = ArrayList()

        dataList.add(Screen3ModelClass1("09:00 AM","Consultation"))
        dataList.add(Screen3ModelClass1("10:00 AM","Control"))
        dataList.add(Screen3ModelClass1("10:30 AM","Blood analysis"))
        dataList.add(Screen3ModelClass1("11:00 AM","General Consultation"))
        dataList.add(Screen3ModelClass1("13:00 PM","Control"))
        dataList.add(Screen3ModelClass1("14:00 PM","Physical Consultation"))

        adapterObj = Screen3ItemAdapter1(dataList,this)
        binding.recyclerView5.layoutManager = LinearLayoutManager(this)
        binding.recyclerView5.adapter = adapterObj
    }
}