package com.epa.aircent.model

import com.google.gson.annotations.SerializedName

data class AircentModel(
    val longDescription : String,

    val iataMain : Int,

    @SerializedName("aircraftTypes") var aircraftTypes : List<AircraftTypes>
)

{
}