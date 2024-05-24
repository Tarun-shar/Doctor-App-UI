package com.example.doctorapp

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorapp.Activity.Screen2Activity
import com.example.doctorapp.Adapters.Screen1ItemAdapter
import com.example.doctorapp.Adapters.Screen1ItemAdapter2
import com.example.doctorapp.ApiImplementation.ApiModels.UsersDataModel
import com.example.doctorapp.ApiImplementation.RetrofitInstance
import com.example.doctorapp.ApiImplementation.RetrofitObject
import com.example.doctorapp.Models.Screen1ModelClass
import com.example.doctorapp.Models.Screen1ModelClass2
import com.example.doctorapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapterObj1: Screen1ItemAdapter
    lateinit var dataList1: ArrayList<Screen1ModelClass>

    lateinit var adapterObj2: Screen1ItemAdapter2
    lateinit var dataList2: ArrayList<Screen1ModelClass2>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//        WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setDataInRecyclerView1()

        setDataInRecyclerView2()

        binding.searchView.setOnClickListener {
            val intent = Intent(this, Screen2Activity::class.java)
            startActivity(intent)
        }

    }

    private fun setDataInRecyclerView1() {

        dataList1 = ArrayList()

        dataList1.add(Screen1ModelClass("Hilary Ouse","Internal medicine","doctor",R.drawable.star,"4.5"))
        dataList1.add(Screen1ModelClass("Eric Widget","Internal medicine","doctor",R.drawable.star,"4.5"))

        adapterObj1 = Screen1ItemAdapter(dataList1,this)
        binding.recyclerView1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView1.adapter = adapterObj1
    }

    private fun setDataInRecyclerView2() {
        dataList2 = ArrayList()

        //    fetch data from api
        val api = RetrofitObject.getInstanceUsers().create(RetrofitInstance::class.java)
        if (!checkNetwork()){
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        else{
            api.getUserData().enqueue(object : Callback<UsersDataModel?> {
                override fun onResponse(
                    call: Call<UsersDataModel?>,
                    response: Response<UsersDataModel?>,
                ) {
                    if (response.isSuccessful){

                        val responseObj = response.body()
                        val responseData = responseObj?.data

                        for (i in 0 until responseData?.size!!){
                            val avatar = responseData[i].avatar
                            val firstName = responseData[i].first_name
                            val last_name = responseData[i].last_name

                            val full_name = "$firstName $last_name"

                            dataList2.add(Screen1ModelClass2(avatar,full_name,"Ophthalmologist",R.drawable.rating_icon,"(16 reviews)"))

                        }

                        adapterObj2 = Screen1ItemAdapter2(dataList2,this@MainActivity)
                        binding.recyclerView2.layoutManager = LinearLayoutManager(this@MainActivity)
                        binding.recyclerView2.adapter = adapterObj2

                    }
                    else{
                        Toast.makeText(this@MainActivity, "Something Went Wrong!", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<UsersDataModel?>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
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