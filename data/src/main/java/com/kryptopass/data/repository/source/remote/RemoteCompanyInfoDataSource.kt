package com.kryptopass.data.repository.source.remote

import com.kryptopass.domain.entity.info.CompanyInfo
import kotlinx.coroutines.flow.Flow

interface RemoteCompanyInfoDataSource {

    fun getCompanyInfo(): Flow<CompanyInfo>
}