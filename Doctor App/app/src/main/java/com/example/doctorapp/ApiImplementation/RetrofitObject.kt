package com.example.doctorapp.ApiImplementation

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    private val BASE_URL_USERS = "https://reqres.in/api/"

    private val BASE_URL_MEMES = "https://api.imgflip.com/"

//    funtion 1 of Users Api
      fun getInstanceUsers(): Retrofit {
           return Retrofit.Builder()
                  .baseUrl(BASE_URL_USERS)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()
      }

    //    funtion 2 of Memes Api
    fun getInstanceMemes(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_MEMES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
