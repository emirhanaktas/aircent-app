package com.epa.aircent.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class AircraftTypes(
    @SerializedName("aircraftTypes")
    val aircraftTypes: List<AircraftType>
) {
    @Keep
    data class AircraftType(
        @SerializedName("iataMain")
        val iataMain: String? = "",
        @SerializedName("iataSub")
        val iataSub: String? = "",
        @SerializedName("longDescription")
        val longDescription: String? = "",
        @SerializedName("shortDescription")
        val shortDescription: String? = ""
    )
}