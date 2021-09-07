package com.epa.aircent.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DestinationTypes(
    @SerializedName("destinations")
    val destinations: List<Destination>
) {
    @Keep
    data class Destination(
        @SerializedName("city")
        val city: Any? = "",
        @SerializedName("country")
        val country: String? = "",
        @SerializedName("iata")
        val iata: String? = "",
        @SerializedName("publicName")
        val publicName: PublicName?
    ) {
        @Keep
        data class PublicName(
            @SerializedName("dutch")
            val dutch: String? = "",
            @SerializedName("english")
            val english: String? = ""
        )
    }
}