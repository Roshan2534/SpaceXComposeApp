package com.kryptopass.data.remote.network.launch

import com.google.gson.annotations.SerializedName

data class Fairings(
    @SerializedName("recovered")
    val recovered: Boolean? = false,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: Boolean? = false,
    @SerializedName("reused")
    val reused: Boolean? = false,
    @SerializedName("ship")
    val ship: String? = ""
)