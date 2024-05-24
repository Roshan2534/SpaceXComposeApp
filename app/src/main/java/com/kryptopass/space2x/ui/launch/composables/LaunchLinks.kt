package com.kryptopass.space2x.ui.launch.composables

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kryptopass.space2x.ui.launch.single.LaunchModel

@Composable
fun LaunchLinks(
    model: LaunchModel,
    onWikiClick: (LaunchModel) -> Unit,
    onVideoClick: (LaunchModel) -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF020035),
            contentColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            val context = LocalContext.current

            ClickableText(
                text = buildAnnotatedString {
                    append("Get flight details on wiki: ")
                    withStyle(style = SpanStyle(color = Color(0xFF86C3FB))) {
                        append(model.links?.articleLink ?: "No wiki")
                    }
                },
                onClick = {
                    onWikiClick(model)
                },
                style = TextStyle(fontSize = 16.sp, color = Color(0xFFFFFFFF)),
                modifier = Modifier
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(model.links?.articleLink))
                        context.startActivity(intent)
                    }
            )

            ClickableText(
                text = buildAnnotatedString {
                    append("See it on youtube video stream: ")
                    withStyle(style = SpanStyle(color = Color(0xFF86C3FB))) {
                        append(model.links?.redditRecovery ?: "No video")
                    }
                },
                onClick = {
                    onVideoClick(model)
                },
                style = TextStyle(fontSize = 16.sp, color = Color(0xFFFFFFFF)),
                modifier = Modifier
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(model.links?.redditRecovery))
                        context.startActivity(intent)
                    }
            )
        }
    }
}