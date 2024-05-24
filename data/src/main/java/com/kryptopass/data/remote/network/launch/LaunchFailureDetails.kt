package com.kryptopass.data.remote.network.launch

import com.google.gson.annotations.SerializedName

data class LaunchFailureDetails(
    @SerializedName("altitude")
    val altitude: Int? = 0,
    @SerializedName("reason")
    val reason: String? = "",
    @SerializedName("time")
    val time: Int? = 0
)