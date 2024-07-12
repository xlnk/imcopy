package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import kotlinx.collections.immutable.ImmutableList

@Composable
fun ChatsListComponent(
    chats: ImmutableList<ChatUi>,
    onSelectChat: (ChatUi) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(items = chats, key = { it.chat.id }) { chat ->
            ChatItem(chat = chat, onSelect = onSelectChat)
        }
    }
}