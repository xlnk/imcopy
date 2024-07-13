package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import io.github.xlnk.telegramcopy.domain.entity.model.ImBaseChat
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatUiPreviewParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.ImIconComponent
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
internal fun ChatItem(
    chat: ChatUi,
    onSelect: (ChatUi) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onSelect(chat) },
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            ImIconComponent(
                icon = chat.icon,
                placeholderColor = chat.iconPlaceholder,
                size = 40.dp
            )
            Text(text = chat.title)
            Column() {
                ImDateComponent(chat.lastUpdated)
                UnreadCountComponent(count = chat.unreadMessagesCount)
            }
        }
    }
}

@Preview
@Composable
private fun ChatItemPreview(@PreviewParameter(ChatUiPreviewParameterProvider::class) chat: ChatUi) {
    AppTheme {
        ChatItem(chat = chat, onSelect = {})
    }
}