package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatsUiPreviewParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme
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
        items(items = chats, key = { it.id.value }) { chat ->
            ChatItem(chat = chat, onSelect = onSelectChat)
        }
    }
}

@Preview
@Composable
private fun ChatsListComponentPreview(
    @PreviewParameter(ChatsUiPreviewParameterProvider::class) chats: ImmutableList<ChatUi>
) {
    AppTheme {
        ChatsListComponent(
            chats,
            {}
        )
    }
}