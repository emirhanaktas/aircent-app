package com.epa.aircent.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class AirlinesTypes(
    @SerializedName("airlines")
    val airlines: List<Airline>
) {
    @Keep
    data class Airline(
        @SerializedName("iata")
        val iata: String? = "",
        @SerializedName("icao")
        val icao: String? = "",
        @SerializedName("nvls")
        val nvls: Int? ,
        @SerializedName("publicName")
        val publicName: String? = ""
    )
}