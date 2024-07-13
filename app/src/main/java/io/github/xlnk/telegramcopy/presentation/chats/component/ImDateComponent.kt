package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme
import io.github.xlnk.telegramcopy.presentation.common.utils.DateUtils
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
internal fun ImDateComponent(
    lastUpdated: LocalDateTime,
    modifier: Modifier = Modifier
) {
    Text(
        text = DateUtils.humanizeDate(lastUpdated),
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ImDateComponentPreviewNow() {
    AppTheme {
        ImDateComponent(LocalDateTime.now())
    }
}

@Preview
@Composable
private fun ImDateComponentPreviewDayAgo() {
    AppTheme {
        ImDateComponent(LocalDate.now().atStartOfDay().minusDays(1))
    }
}