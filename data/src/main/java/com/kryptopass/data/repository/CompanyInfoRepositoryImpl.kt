package com.kryptopass.data.repository

import com.kryptopass.data.repository.source.local.LocalCompanyInfoDataSource
import com.kryptopass.data.repository.source.remote.RemoteCompanyInfoDataSource
import com.kryptopass.domain.entity.info.CompanyInfo
import com.kryptopass.domain.repo.CompanyInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class CompanyInfoRepositoryImpl(
    private val remoteSource: RemoteCompanyInfoDataSource,
    private val localSource: LocalCompanyInfoDataSource
): CompanyInfoRepository {

    override fun getCompanyInfo(): Flow<CompanyInfo> =
        remoteSource.getCompanyInfo().onEach {
            localSource.addCompanyInfo(it)
        }
}