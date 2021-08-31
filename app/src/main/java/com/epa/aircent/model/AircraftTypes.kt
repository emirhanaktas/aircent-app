package com.epa.aircent.model

import com.google.gson.annotations.SerializedName

data class AircraftTypes(

    @SerializedName("iataMain") var iataMain : String,
    @SerializedName("iataSub") var iataSub : String,
    @SerializedName("longDescription") var longDescription : String,
    @SerializedName("shortDescription") var shortDescription : String

)
