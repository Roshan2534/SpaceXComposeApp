package com.kryptopass.domain.usecase

import com.kryptopass.domain.entity.info.CompanyInfo
import com.kryptopass.domain.repo.CompanyInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCompanyInfoUseCase(
    configuration: Configuration,
    private val repository: CompanyInfoRepository
) : UseCase<GetCompanyInfoUseCase.Request, GetCompanyInfoUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repository.getCompanyInfo()
            .map {
                Response(it)
            }

    data object Request : UseCase.Request
    data class Response(val companyInfo: CompanyInfo) : UseCase.Response
}