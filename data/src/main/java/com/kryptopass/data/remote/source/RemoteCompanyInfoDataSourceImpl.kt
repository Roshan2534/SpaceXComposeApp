package com.kryptopass.data.remote.source

import com.kryptopass.data.remote.network.info.CompanyInfoService
import com.kryptopass.data.remote.network.info.CompanyModel
import com.kryptopass.data.repository.source.remote.RemoteCompanyInfoDataSource
import com.kryptopass.domain.entity.UseCaseException
import com.kryptopass.domain.entity.info.CompanyInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteCompanyInfoDataSourceImpl @Inject constructor(
    private val service: CompanyInfoService
): RemoteCompanyInfoDataSource {

    override fun getCompanyInfo(): Flow<CompanyInfo> = flow {
        emit(service.getCompanyInfo())
    }.map { coin ->
        convert(coin)
    }.catch {
        throw UseCaseException.CompanyInfoException(it)
    }

    private fun convert(model: CompanyModel) = CompanyInfo(
        model.name, model.founder, model.founded, model.employees, model.launchSites, model.valuation
    )
}