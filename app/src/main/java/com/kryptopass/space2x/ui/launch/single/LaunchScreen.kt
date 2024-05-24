package com.kryptopass.space2x.ui.launch.single

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kryptopass.common.nav.LaunchInput
import com.kryptopass.common.state.CommonScreen
import com.kryptopass.domain.entity.Interaction
import com.kryptopass.space2x.ui.launch.composables.LaunchDetails
import com.kryptopass.space2x.ui.launch.composables.LaunchLinks
import com.kryptopass.space2x.ui.launch.composables.LaunchPatch

@Composable
fun LaunchScreen(
    viewModel: LaunchViewModel,
    input: LaunchInput
) {
    viewModel.uiStateFlow.collectAsState().value.let { result ->
        CommonScreen(result) { model ->
            Launch(model, onWikiClick = {
                viewModel.submitAction(
                    LaunchUiAction.WikiClick(
                        it.links?.articleLink,
                        Interaction("", 0)
                    )
                )
            }, onVideoClick = {
                viewModel.submitAction(
                    LaunchUiAction.VideoClick(
                        it.links?.redditRecovery,
                        Interaction("", 0)
                    )
                )
            })
        }
    }
    LaunchedEffect(input.flightNumber) {
        viewModel.submitAction(LaunchUiAction.Load(input.flightNumber))
    }
}

@Composable
fun Launch(
    model: LaunchModel,
    onWikiClick: (LaunchModel) -> Unit,
    onVideoClick: (LaunchModel) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        LaunchPatch(model.links?.missionPatch)
        LaunchDetails(model)
        LaunchLinks(model, onWikiClick, onVideoClick)
    }
}