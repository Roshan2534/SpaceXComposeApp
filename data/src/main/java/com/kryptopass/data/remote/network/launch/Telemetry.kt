package com.kryptopass.data.remote.network.launch

import com.google.gson.annotations.SerializedName

data class Telemetry(
    @SerializedName("flight_club")
    val flightClub: String? = ""
)