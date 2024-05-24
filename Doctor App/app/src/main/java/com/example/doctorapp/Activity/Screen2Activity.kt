package com.example.doctorapp.Activity

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorapp.Adapters.Screen1ItemAdapter
import com.example.doctorapp.Adapters.Screen1ItemAdapter2
import com.example.doctorapp.Adapters.Screen2ItemAdapter1
import com.example.doctorapp.ApiImplementation.ApiModels.MemesModelClass.MemeDataModel
import com.example.doctorapp.ApiImplementation.ApiModels.UsersDataModel
import com.example.doctorapp.ApiImplementation.RetrofitInstance
import com.example.doctorapp.ApiImplementation.RetrofitObject
import com.example.doctorapp.Models.Screen1ModelClass
import com.example.doctorapp.Models.Screen1ModelClass2
import com.example.doctorapp.Models.Screen2ModelClass1
import com.example.doctorapp.R
import com.example.doctorapp.databinding.ActivityScreen2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Screen2Activity : AppCompatActivity() {

    lateinit var binding: ActivityScreen2Binding

    lateinit var adapterObj1: Screen2ItemAdapter1
    lateinit var dataList1: ArrayList<Screen2ModelClass1>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreen2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setDataInRecyclerView()
    }

    private fun setDataInRecyclerView() {
        dataList1 = ArrayList()

        val api = RetrofitObject.getInstanceMemes().create(RetrofitInstance::class.java)
        if (!checkNetwork()){
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        else{
            api.getMemeData().enqueue(object : Callback<MemeDataModel?> {
                override fun onResponse(
                    call: Call<MemeDataModel?>,
                    response: Response<MemeDataModel?>,
                ) {
                    if(response.isSuccessful){
                        val responseObj = response.body()
                        val responseData = responseObj?.data
                        val responseMeme = responseData?.memes

                        for (i in 0 until responseMeme?.size!!){
                            val image = responseMeme[i].url
                            val meme = responseMeme[i].name

                            val name = meme.split(" ")[0]

                            dataList1.add(Screen2ModelClass1(image,name,"Dentist","Espanola, NM","4.0",R.drawable.star))

                        }

                        adapterObj1 = Screen2ItemAdapter1(dataList1,this@Screen2Activity)
                        binding.recyclerView3.layoutManager = LinearLayoutManager(this@Screen2Activity)
                        binding.recyclerView3.adapter = adapterObj1

                    }
                    else{
                        Toast.makeText(this@Screen2Activity, "Something went\nwrong", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<MemeDataModel?>, t: Throwable) {
                    Toast.makeText(this@Screen2Activity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            })
        }

    }

    //    Check Internet Connection
    private fun checkNetwork(): Boolean {
        var connected = false
        try {
            val cm =
                applicationContext.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val nInfo = cm.activeNetworkInfo
            connected = nInfo != null && nInfo.isAvailable && nInfo.isConnected
            return connected
        } catch (e: Exception) {
            Log.e("Connectivity Exception", e.message!!)
        }
        return connected
    }
}