package com.kryptopass.space2x.ui.launch.single

import com.kryptopass.common.state.UiSingleEvent

// NOTE: concrete UiSingleEvent specific for Launch
sealed class LaunchUiSingleEvent : UiSingleEvent {

    data class OpenUrl(val navRoute: String?) : LaunchUiSingleEvent()
}