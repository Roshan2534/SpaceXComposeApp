package com.kryptopass.space2x.ui.launch.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.kryptopass.common.state.CommonScreen
import com.kryptopass.space2x.ui.info.CompanyInfoScreen
import com.kryptopass.space2x.ui.info.CompanyInfoViewModel
import com.kryptopass.space2x.ui.launch.composables.LaunchList
import com.kryptopass.space2x.ui.launch.composables.LaunchScreenHeader
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LaunchListScreen(
    viewModel: LaunchListViewModel,
    infoViewModel: CompanyInfoViewModel,
    navController: NavController
) {
    // NOTE: only execute once, keep from recomposing/re-executing same block
    // can also be used to ensure that we do not trigger multiple data loads
    LaunchedEffect(Unit) {
        viewModel.submitAction(LaunchListUiAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LaunchScreenHeader()
                CompanyInfoScreen(infoViewModel)
                LaunchList(it) { item ->
                    viewModel.submitAction(
                        LaunchListUiAction.OnLaunchItemClick(
                            item.flightNumber
                        )
                    )
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is LaunchListUiSingleEvent.OpenDetailsScreen -> {
                    navController.navigate(it.navRoute)
                }
            }
        }
    }
}
