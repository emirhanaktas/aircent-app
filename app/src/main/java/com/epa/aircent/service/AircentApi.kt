package com.epa.aircent.service

import com.epa.aircent.`object`.AircentConst
import com.epa.aircent.`object`.DestinationConst
import com.epa.aircent.model.AircraftTypes
import com.epa.aircent.model.DestinationTypes
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

    @Headers(
        "Accept: application/json",
        "app_id:" + DestinationConst.APP_ID,
        "app_key:" + DestinationConst.API_KEY,
        "ResourceVersion: v4")
    @GET("public-flights/destinations?page=0")
    open fun getDestinationTypes(): Call<DestinationTypes>



}