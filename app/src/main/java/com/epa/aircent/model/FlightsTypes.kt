package com.epa.aircent.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class FlightsTypes(
    @SerializedName("flights")
    val flights: List<Flight>
) {
    @Keep
    data class Flight(
        @SerializedName("actualLandingTime")
        val actualLandingTime: Any? ="",
        @SerializedName("actualOffBlockTime")
        val actualOffBlockTime: String? = "",
        @SerializedName("aircraftRegistration")
        val aircraftRegistration: String? = "",
        @SerializedName("aircraftType")
        val aircraftType: AircraftType?,
        @SerializedName("airlineCode")
        val airlineCode: Int? ,
        @SerializedName("baggageClaim")
        val baggageClaim: Any? = "",
        @SerializedName("checkinAllocations")
        val checkinAllocations: Any? = "",
        @SerializedName("codeshares")
        val codeshares: Any? = "",
        @SerializedName("estimatedLandingTime")
        val estimatedLandingTime: Any? = "",
        @SerializedName("expectedSecurityFilter")
        val expectedSecurityFilter: Any? = "",
        @SerializedName("expectedTimeBoarding")
        val expectedTimeBoarding: Any? = "",
        @SerializedName("expectedTimeGateClosing")
        val expectedTimeGateClosing: Any? = "",
        @SerializedName("expectedTimeGateOpen")
        val expectedTimeGateOpen: Any? = "",
        @SerializedName("expectedTimeOnBelt")
        val expectedTimeOnBelt: Any? = "",
        @SerializedName("flightDirection")
        val flightDirection: String? = "",
        @SerializedName("flightName")
        val flightName: String? = "",
        @SerializedName("flightNumber")
        val flightNumber: Int? ,
        @SerializedName("gate")
        val gate: Any? = "",
        @SerializedName("id")
        val id: String? = "",
        @SerializedName("isOperationalFlight")
        val isOperationalFlight: Boolean? ,
        @SerializedName("lastUpdatedAt")
        val lastUpdatedAt: String? = "",
        @SerializedName("mainFlight")
        val mainFlight: String? = "",
        @SerializedName("pier")
        val pier: Any? = "",
        @SerializedName("prefixIATA")
        val prefixIATA: String? = "",
        @SerializedName("prefixICAO")
        val prefixICAO: String? = "",
        @SerializedName("publicEstimatedOffBlockTime")
        val publicEstimatedOffBlockTime: String? = "",
        @SerializedName("publicFlightState")
        val publicFlightState: PublicFlightState?,
        @SerializedName("route")
        val route: Route?,
        @SerializedName("scheduleDate")
        val scheduleDate: String? = "",
        @SerializedName("scheduleDateTime")
        val scheduleDateTime: String? = "",
        @SerializedName("scheduleTime")
        val scheduleTime: String? = "",
        @SerializedName("schemaVersion")
        val schemaVersion: String? = "",
        @SerializedName("serviceType")
        val serviceType: String? = "",
        @SerializedName("terminal")
        val terminal: Any? = "",
        @SerializedName("transferPositions")
        val transferPositions: Any? = ""
    ) {
        @Keep
        data class AircraftType(
            @SerializedName("iataMain")
            val iataMain: String? = "",
            @SerializedName("iataSub")
            val iataSub: String? = ""
        )

        @Keep
        data class PublicFlightState(
            @SerializedName("flightStates")
            val flightStates: List<String?>?
        )

        @Keep
        data class Route(
            @SerializedName("destinations")
            val destinations: List<String?>?,
            @SerializedName("eu")
            val eu: String? = "",
            @SerializedName("visa")
            val visa: Boolean?
        )
    }
}