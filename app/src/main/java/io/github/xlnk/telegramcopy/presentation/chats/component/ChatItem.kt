package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatUiPreviewParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.ImIconComponent
import io.github.xlnk.telegramcopy.presentation.common.component.ImMuteIndicator
import io.github.xlnk.telegramcopy.presentation.common.component.ImPinnedIndicator
import io.github.xlnk.telegramcopy.presentation.common.component.UnreadCountComponent
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme

@Composable
internal fun ChatItem(
    chat: ChatUi,
    onSelect: (ChatUi) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { onSelect(chat) },
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ImIconComponent(
                icon = chat.icon,
                placeholderColor = chat.iconPlaceholder,
                size = 40.dp
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = chat.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    if (chat.muted) {
                        ImMuteIndicator(modifier = Modifier.padding(start = 4.dp))
                    }
                }
                ChatItemMessage(
                    message = chat.lastMessage,
                    sender = chat.lastMessageSender,
                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                ImDateComponent(chat.lastUpdated)
                if (chat.unreadMessagesCount > 0) {
                    UnreadCountComponent(count = chat.unreadMessagesCount)
                } else {
                    ImPinnedIndicator()
                }
            }
        }
    }
}

@Composable
private fun ChatItemMessage(
    message: String,
    modifier: Modifier = Modifier,
    sender: String? = null,
) {
    Row(modifier = modifier,) {
        if (sender != null) {
            Text(
                text = "$sender: ",
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Text(
            text = message,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
private fun ChatItemPreview(@PreviewParameter(ChatUiPreviewParameterProvider::class) chat: ChatUi) {
    AppTheme {
        ChatItem(chat = chat, onSelect = {})
    }
}