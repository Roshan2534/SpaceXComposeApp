package com.kryptopass.space2x.ui.launch.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kryptopass.space2x.ui.launch.single.LaunchModel

@Composable
fun LaunchDetails(model: LaunchModel) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = "Mission Name: ${model.missionName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Rocket Name: ${model.rocket?.rocketName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Launch Site: ${model.launchSite?.siteName}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Details: ${model.details}",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}