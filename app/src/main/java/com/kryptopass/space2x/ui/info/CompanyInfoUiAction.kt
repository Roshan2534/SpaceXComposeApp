package com.kryptopass.space2x.ui.info

import com.kryptopass.common.state.UiAction

// NOTE: concrete UiAction specific for CompanyInfo
sealed class CompanyInfoUiAction : UiAction {
    data object Load : CompanyInfoUiAction()
}