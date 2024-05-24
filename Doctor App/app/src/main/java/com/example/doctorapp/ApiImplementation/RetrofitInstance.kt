package com.example.doctorapp.ApiImplementation

import com.example.doctorapp.ApiImplementation.ApiModels.MemesModelClass.MemeDataModel
import com.example.doctorapp.ApiImplementation.ApiModels.UsersDataModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInstance {

//    API 1 of users
    @GET("users")
    fun getUserData(): Call<UsersDataModel>

//    API 2 of memes
    @GET("get_memes")
    fun getMemeData(): Call<MemeDataModel>
}