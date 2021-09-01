package com.epa.aircent.retrofit

import com.epa.aircent.adapter.AircentAdapter
import com.epa.aircent.model.AircentModel
import com.epa.aircent.service.AircentApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retro {
    private val BASE_URL = "https://api.schiphol.nl/"
    private var aircentModel: ArrayList<AircentModel>? = null
    private var aircentViewAdapt: AircentAdapter? = null

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

    val service = retrofit.create(AircentApi::class.java)
    val call = service.getAircraftTypes()
}