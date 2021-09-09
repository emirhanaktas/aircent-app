package com.epa.aircent.service

import com.epa.aircent.`object`.FlightsConst
import com.epa.aircent.`object`.AircentConst
import com.epa.aircent.`object`.DestinationConst
import com.epa.aircent.model.AircraftTypes
import com.epa.aircent.model.AirlinesTypes
import com.epa.aircent.model.DestinationTypes
import com.epa.aircent.model.FlightsTypes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface AircentApi {




    @Headers(
        "Accept: application/json",
        "app_id:" + AircentConst.APP_ID,
        "app_key:" + AircentConst.API_KEY,
        "ResourceVersion: v4")
    @GET("aircrafttypes?page=1")
    open fun getAircraftTypes(): Call<AircraftTypes>

    @Headers(
        "Accept: application/json",
        "app_id:" + DestinationConst.APP_ID,
        "app_key:" + DestinationConst.API_KEY,
        "ResourceVersion: v4")
    @GET("destinations?page=0")
    open fun getDestinationTypes(): Call<DestinationTypes>

    @Headers(
        "Accept: application/json",
        "app_id:" + DestinationConst.APP_ID,
        "app_key:" + DestinationConst.API_KEY,
        "ResourceVersion: v4")
    @GET("airlines?page=0")
    open fun getAirlinesTypes(): Call<AirlinesTypes>

    @Headers(
        "Accept: application/json",
        "app_id:" + FlightsConst.APP_ID,
        "app_key:" + FlightsConst.API_KEY,
        "ResourceVersion: v4")
    @GET("flights?page=0")
    open fun getFlightsTypes(): Call<FlightsTypes>



}