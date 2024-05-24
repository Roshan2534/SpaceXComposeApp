package com.kryptopass.space2x.ui.launch.list

import com.kryptopass.common.state.UiAction

// NOTE: concrete UiAction specific for Launch
sealed class LaunchListUiAction : UiAction {

    data object Load : LaunchListUiAction()
    data class OnLaunchItemClick(val flightNumber: Int?) : LaunchListUiAction()
}