package com.kryptopass.data.remote.network.launch

import com.google.gson.annotations.SerializedName

data class Rocket(
    @SerializedName("fairings")
    val fairings: Fairings? = Fairings(),
    @SerializedName("first_stage")
    val firstStage: FirstStage? = FirstStage(),
    @SerializedName("rocket_id")
    val rocketId: String? = "",
    @SerializedName("rocket_name")
    val rocketName: String? = "",
    @SerializedName("rocket_type")
    val rocketType: String? = "",
    @SerializedName("second_stage")
    val secondStage: SecondStage? = SecondStage()
)