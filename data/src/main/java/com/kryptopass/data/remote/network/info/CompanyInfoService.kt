package com.kryptopass.data.remote.network.info

import retrofit2.http.GET

interface CompanyInfoService {

    @GET("info")
    suspend fun getCompanyInfo(): CompanyModel
}