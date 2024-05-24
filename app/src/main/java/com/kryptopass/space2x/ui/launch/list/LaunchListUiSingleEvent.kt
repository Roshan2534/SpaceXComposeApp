package com.kryptopass.space2x.ui.launch.list

import com.kryptopass.common.state.UiSingleEvent

// NOTE: concrete UiSingleEvent specific for Launch
sealed class LaunchListUiSingleEvent : UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String) : LaunchListUiSingleEvent()
}