package com.kryptopass.space2x.ui.launch.list

import androidx.lifecycle.viewModelScope
import com.kryptopass.common.nav.LaunchInput
import com.kryptopass.common.nav.NavRoutes
import com.kryptopass.common.state.MviViewModel
import com.kryptopass.common.state.UiState
import com.kryptopass.domain.usecase.GetLaunchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchListViewModel @Inject constructor(
    private val useCase: GetLaunchesUseCase,
    private val converter: LaunchListConverter,
): MviViewModel<LaunchListModel, UiState<LaunchListModel>, LaunchListUiAction, LaunchListUiSingleEvent>() {

    override fun initState(): UiState<LaunchListModel> = UiState.Loading

    override fun handleAction(action: LaunchListUiAction) {
        when (action) {
            is LaunchListUiAction.Load -> {
                loadLaunches()
            }

            is LaunchListUiAction.OnLaunchItemClick -> {
                submitSingleEvent(
                    LaunchListUiSingleEvent.OpenDetailsScreen(
                        NavRoutes.Launch.routeForLaunch(
                            LaunchInput(action.flightNumber)
                        )
                    )
                )
            }
        }
    }

    private fun loadLaunches() {
        viewModelScope.launch {
            useCase.execute(GetLaunchesUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }
}