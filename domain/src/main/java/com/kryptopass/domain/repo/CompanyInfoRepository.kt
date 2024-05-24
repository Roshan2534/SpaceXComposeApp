package com.kryptopass.domain.repo

import com.kryptopass.domain.entity.info.CompanyInfo
import kotlinx.coroutines.flow.Flow

interface CompanyInfoRepository {

    // https://stackoverflow.com/questions/75112149/should-kotlin-flows-be-used-when-passing-a-single-object-to-viewmodel-in-android
    // TODO: convert to suspend??
    fun getCompanyInfo(): Flow<CompanyInfo>
}