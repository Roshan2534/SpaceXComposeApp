package com.kryptopass.space2x.ui.info

import android.content.Context
import com.kryptopass.common.state.CommonResultConverter
import com.kryptopass.domain.usecase.GetCompanyInfoUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CompanyInfoConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetCompanyInfoUseCase.Response, CompanyInfoModel>() {

    override fun convertSuccess(data: GetCompanyInfoUseCase.Response): CompanyInfoModel =
        CompanyInfoModel(
            data.companyInfo.companyName,
            data.companyInfo.founderName,
            data.companyInfo.foundedYear,
            data.companyInfo.employeeCount,
            data.companyInfo.launchSites,
            data.companyInfo.valuation
        )
}