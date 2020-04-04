package com.idea.xxx.kwarantariusz.RetrofitClient

import com.idea.xxx.kwarantariusz.Service.KwarantariuszApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
   // private val BASE_URL = "http://localhost:8080/"
    private val BASE_URL = "https://quaranteerserver.000webhostapp.com/"

    fun makeRetrofitService(): KwarantariuszApiService {
              return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().build())
                    .build().create(KwarantariuszApiService::class.java)
            }
    }
