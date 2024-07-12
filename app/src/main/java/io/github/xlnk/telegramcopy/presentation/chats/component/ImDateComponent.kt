package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
internal fun ImDateComponent(
    lastUpdated: ZonedDateTime,
    modifier: Modifier = Modifier
) {
    Text(
        text = DateTimeFormatter.ISO_LOCAL_TIME.format(lastUpdated),
    )
}