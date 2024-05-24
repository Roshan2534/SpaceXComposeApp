package com.kryptopass.space2x.ui.launch.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kryptopass.space2x.ui.launch.list.LaunchListItemModel
import com.kryptopass.space2x.ui.launch.list.LaunchListModel

@Composable
fun LaunchList(
    model: LaunchListModel,
    onRowClick: (LaunchListItemModel) -> Unit,
) {
    Column {
        LaunchTitleHeader()
        LazyColumn(modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 4.dp)) {
            itemsIndexed(model.items) { index, item ->
                Column(modifier = Modifier
                    .clickable {
                        onRowClick(item)
                    }
                ) {
                    LaunchItem(item, index)
                }
            }
        }
    }
}