package com.kryptopass.data.remote.network.launch

import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchService {

    @GET("launches")
    suspend fun getLaunches(): List<LaunchModelItem>

    @GET("launches/{flightNumber}")
    suspend fun getLaunch(@Path("flightNumber") flightNumber: Int?): LaunchModelItem
}