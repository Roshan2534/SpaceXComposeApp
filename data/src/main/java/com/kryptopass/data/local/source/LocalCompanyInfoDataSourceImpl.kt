package com.kryptopass.data.local.source

import com.kryptopass.data.local.db.info.CompanyInfoDao
import com.kryptopass.data.local.db.info.CompanyInfoEntity
import com.kryptopass.data.repository.source.local.LocalCompanyInfoDataSource
import com.kryptopass.domain.entity.info.CompanyInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalCompanyInfoDataSourceImpl @Inject constructor(
    private val dao: CompanyInfoDao
) : LocalCompanyInfoDataSource {

    override fun getCompanyInfo(): Flow<CompanyInfo> =
        dao.getCompanyInfo().map {
            CompanyInfo(
                it.companyName, it.founderName, it.foundedYear, it.employeeCount, it.launchSites,
                it.valuation
            )
        }

    override suspend fun addCompanyInfo(info: CompanyInfo) =
        dao.insertCompanyInfo(
            CompanyInfoEntity(
                null, info.companyName, info.founderName, info.foundedYear, info.employeeCount,
                info.launchSites, info.valuation
            )
        )
}