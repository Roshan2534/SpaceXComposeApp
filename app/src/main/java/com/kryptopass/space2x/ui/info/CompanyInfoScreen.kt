package com.kryptopass.space2x.ui.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kryptopass.common.state.CommonScreen

@Composable
fun CompanyInfoScreen(
    viewModel: CompanyInfoViewModel
) {
    // NOTE: only execute once, keep from recomposing/re-executing same block
    // can also be used to ensure that we do not trigger multiple data loads
    LaunchedEffect(Unit) {
        viewModel.submitAction(CompanyInfoUiAction.Load)
    }

    viewModel.uiStateFlow.collectAsState().value.let { result ->
        CommonScreen(result) { model ->
            Column(
                modifier = Modifier
                    .padding(top = 8.dp, start = 4.dp, end = 4.dp)
            ) {
                Text(
                    text = "COMPANY",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text(
                        text = "${model.companyName} was founded by ${model.founderName} in " +
                                "${model.foundedYear}. It now has ${model.employeeCount} employees, " +
                                "${model.launchSites} launch sites, and is valued at USD" +
                                " ${model.valuation}",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}
