package com.kryptopass.space2x.ui.info

import androidx.lifecycle.viewModelScope
import com.kryptopass.common.state.MviViewModel
import com.kryptopass.common.state.UiSingleEvent
import com.kryptopass.common.state.UiState
import com.kryptopass.domain.usecase.GetCompanyInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val useCase: GetCompanyInfoUseCase,
    private val converter: CompanyInfoConverter
) : MviViewModel<CompanyInfoModel, UiState<CompanyInfoModel>, CompanyInfoUiAction, UiSingleEvent>() {

    override fun initState(): UiState<CompanyInfoModel> = UiState.Loading

    override fun handleAction(action: CompanyInfoUiAction) {
        when (action) {
            is CompanyInfoUiAction.Load -> {
                loadCompanyInfo()
            }
        }
    }

    private fun loadCompanyInfo() {
        viewModelScope.launch {
            useCase.execute(GetCompanyInfoUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }
}