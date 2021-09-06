package com.epa.aircent.service

import com.epa.aircent.`object`.AircentConst
import com.epa.aircent.model.AircraftTypes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface AircentApi {




    @Headers(
        "Accept: application/json",
        "app_id:" + AircentConst.APP_ID,
        "app_key:" + AircentConst.API_KEY,
        "ResourceVersion: v4")
    @GET("public-flights/aircrafttypes?page=1")
    open fun getAircraftTypes(): Call<AircraftTypes>



}