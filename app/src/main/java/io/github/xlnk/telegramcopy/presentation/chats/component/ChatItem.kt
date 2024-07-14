package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.xlnk.telegramcopy.R
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatUiPreviewParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.ImIconComponent
import io.github.xlnk.telegramcopy.presentation.common.component.ImMuteIndicator
import io.github.xlnk.telegramcopy.presentation.common.component.ImPinnedIndicator
import io.github.xlnk.telegramcopy.presentation.common.component.UnreadCountComponent
import io.github.xlnk.telegramcopy.presentation.common.extensions.toDp
import io.github.xlnk.telegramcopy.presentation.common.model.Sender
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme

@Composable
internal fun ChatItem(
    chat: ChatUi,
    onSelect: (ChatUi) -> Unit,
    modifier: Modifier = Modifier
) {
    val background = if (chat.isPinned) {
        MaterialTheme.colorScheme.surfaceVariant
    } else {
        MaterialTheme.colorScheme.surface
    }

    Surface(
        onClick = { onSelect(chat) },
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape,
        color = background,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ImIconComponent(
                icon = chat.icon,
                placeholderColor = chat.iconPlaceholder,
                size = 40.dp,
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Spacer(Modifier)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = chat.title,
                        style = MaterialTheme.typography.titleMedium,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.weight(1f),
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                    if (chat.muted) {
                        ImMuteIndicator(
                            modifier = Modifier.padding(start = 4.dp, end = 8.dp)
                        )
                    }
                    ImDateComponent(chat.lastUpdated,)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    ChatItemMessage(
                        message = chat.lastMessage,
                        sender = chat.lastMessageSender,
                        modifier = Modifier.weight(1f)
                    )
                    if (chat.unreadMessagesCount > 0) {
                        UnreadCountComponent(
                            count = chat.unreadMessagesCount,
                            size = 20.sp,
                            isHighlighted = chat.isPinned,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    } else if (chat.isPinned) {
                        ImPinnedIndicator(20.sp.toDp())
                    }
                }
                HorizontalDivider(thickness = 0.5.dp)
            }
        }
    }
}

@Composable
private fun ChatItemMessage(
    message: String,
    modifier: Modifier = Modifier,
    sender: Sender = Sender.NotMatter,
) {
    Row(modifier = modifier,) {
        val senderText = when (sender) {
            Sender.NotMatter -> null
            Sender.You -> stringResource(R.string.sender_you_text)
            is Sender.Other -> sender.shortName
        }
        if (senderText != null) {
            val senderColor = if (sender is Sender.Other) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface
            }
            Text(
                text = "$senderText: ",
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium,
                color = senderColor
            )
        }
        Text(
            text = message,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
    }
}

@PreviewFontScale
@Composable
private fun ChatItemPreview(@PreviewParameter(ChatUiPreviewParameterProvider::class) chat: ChatUi) {
    AppTheme {
        ChatItem(chat = chat, onSelect = {})
    }
}