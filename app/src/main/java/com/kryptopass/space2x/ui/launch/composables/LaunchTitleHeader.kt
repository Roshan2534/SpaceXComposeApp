package com.kryptopass.space2x.ui.launch.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LaunchTitleHeader() {
    Text(
        text = "LAUNCHES",
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(top = 8.dp, start = 12.dp)
    )
}