package com.epa.aircent.retrofit

import com.epa.aircent.service.AircentApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retro {
    private val BASE_URL = "https://api.schiphol.nl/public-flights/"


    private var aircentApi: AircentApi? = null

    fun getRetrofit(): AircentApi? {
        if(aircentApi != null)
            return aircentApi
        else{
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            aircentApi =  retrofit.create(AircentApi::class.java)

            return aircentApi
        }
    }




}