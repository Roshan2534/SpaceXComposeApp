package com.kryptopass.data.remote.network.launch

import com.google.gson.annotations.SerializedName

data class SecondStage(
    @SerializedName("block")
    val block: Int? = 0,
    @SerializedName("payloads")
    val payloads: List<Payload?>? = listOf()
)