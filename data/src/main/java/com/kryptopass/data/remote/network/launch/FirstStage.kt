package com.kryptopass.data.remote.network.launch

import com.google.gson.annotations.SerializedName

data class FirstStage(
    @SerializedName("cores")
    val cores: List<Core?>? = listOf()
)