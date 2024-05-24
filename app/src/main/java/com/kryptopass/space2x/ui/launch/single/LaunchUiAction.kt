package com.kryptopass.space2x.ui.launch.single

import com.kryptopass.common.state.UiAction
import com.kryptopass.domain.entity.Interaction

sealed class LaunchUiAction : UiAction {

    data class Load(val flightNumber: Int?) : LaunchUiAction()

    data class WikiClick(val wikiUrl: String?, val interaction: Interaction) : LaunchUiAction()
    data class VideoClick(val redditUrl: String?, val interaction: Interaction) : LaunchUiAction()
}