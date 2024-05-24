package com.kryptopass.space2x.ui.launch.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Scale
import coil.size.Size
import com.kryptopass.space2x.ui.launch.list.LaunchListItemModel
import com.kryptopass.space2x.util.launchItemHelper

@Composable
fun LaunchItemRow(item: LaunchListItemModel) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val flightDetails = launchItemHelper(item)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.links?.missionPatch)
                .crossfade(true)
                .size(Size(120, 120))
                .scale(Scale.FIT)
                .precision(Precision.EXACT)
                .build(),
            contentDescription = null
        )
        Column {
            Text(
                text = flightDetails.missionName,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${flightDetails.dateTime}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "${flightDetails.rocket}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "${flightDetails.days}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "UNIX: ${item.launchDateUnix}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.flightNumber.toString(),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Icon(
                imageVector = ImageVector.vectorResource(flightDetails.patch ?: 0),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}