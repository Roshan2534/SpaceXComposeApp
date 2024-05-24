package com.kryptopass.data.repository.source.local

import com.kryptopass.domain.entity.info.CompanyInfo
import kotlinx.coroutines.flow.Flow

interface LocalCompanyInfoDataSource {

    fun getCompanyInfo(): Flow<CompanyInfo>

    suspend fun addCompanyInfo(info: CompanyInfo)
}