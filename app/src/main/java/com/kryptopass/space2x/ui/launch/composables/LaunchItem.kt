package com.kryptopass.space2x.ui.launch.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kryptopass.space2x.ui.launch.list.LaunchListItemModel

@Composable
fun LaunchItem(
    item: LaunchListItemModel,
    index: Int
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (index % 2 == 0) Color(0xFFF0F8FF) else Color(0xFF020035),
            contentColor = if (index % 2 == 0) Color(0xFF020035) else Color(0xFFF0F8FF)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        LaunchItemRow(item)
    }
}