package com.kryptopass.space2x.ui.launch.single

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.viewModelScope
import com.kryptopass.common.state.MviViewModel
import com.kryptopass.common.state.UiSingleEvent
import com.kryptopass.common.state.UiState
import com.kryptopass.domain.usecase.GetLaunchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val useCase: GetLaunchUseCase,
    private val converter: LaunchConverter,
    @ApplicationContext private val context: Context
) : MviViewModel<LaunchModel, UiState<LaunchModel>, LaunchUiAction, UiSingleEvent>() {

    override fun initState(): UiState<LaunchModel> = UiState.Loading

    override fun handleAction(action: LaunchUiAction) {
        when (action) {
            is LaunchUiAction.Load -> {
                loadLaunch(action.flightNumber)
            }

            is LaunchUiAction.WikiClick -> {
                openUrl(action.wikiUrl)
            }

            is LaunchUiAction.VideoClick -> {
                openUrl(action.redditUrl)
            }
        }
    }

    private fun loadLaunch(flightNumber: Int?) {
        viewModelScope.launch {
            useCase.execute(GetLaunchUseCase.Request(flightNumber))
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }

    private fun openUrl(url: String?) {
        if (url != null) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

    }
}