package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.xlnk.telegramcopy.domain.entity.model.ImBaseChat
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.ImIconComponent
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
        modifier = modifier,
    ) {
        Row() {
            ImIconComponent(
                icon = chat.icon,
                placeholderColor = chat.iconPlaceholder,
                size = 40.dp
            )
            Text(text = chat.chat.name)
            Column() {
                ImDateComponent(chat.chat.lastUpdated)
                UnreadCountComponent(count = chat.chat.unreadMessagesCount)
            }
        }
    }
}
