package com.example.doctorapp.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorapp.Adapters.Screen2ItemAdapter1
import com.example.doctorapp.Adapters.Screen5ItemAdapter
import com.example.doctorapp.Models.Screen5ModelClass
import com.example.doctorapp.R
import com.example.doctorapp.databinding.ActivityScreen5Binding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class Screen5Activity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    lateinit var binding:ActivityScreen5Binding
    lateinit var adapter:Screen5ItemAdapter
    lateinit var datalist:ArrayList<Screen5ModelClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        setDataInRecyclerView()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val delhi = LatLng(28.614067, 77.229729)
        mMap.addMarker(MarkerOptions().position(delhi).title("Marker in delhi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi))
        val zoomLevel = 15.0f // This value controls the zoom level
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(delhi, zoomLevel))

    }

    private fun setDataInRecyclerView() {
        datalist = ArrayList()

        datalist.add(Screen5ModelClass(R.color.GREY,"Desmond Eagle","Sandusky, Ohio","+12 345 678 901","24h"))
        datalist.add(Screen5ModelClass(R.color.light_pink,"Desmond Eagle","Sandusky, Ohio","+12 345 678 901","24h"))
        datalist.add(Screen5ModelClass(R.color.skyblue,"Desmond Eagle","Sandusky, Ohio","+12 345 678 901","24h"))

        adapter = Screen5ItemAdapter(datalist,this)
        binding.recyclerView6.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView6.adapter = adapter

    }

}