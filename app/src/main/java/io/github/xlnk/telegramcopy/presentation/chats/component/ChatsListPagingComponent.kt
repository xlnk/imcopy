package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatsUiPagingDataParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.LoadingIndicator
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun ChatsListPagingComponent(
    chatsPagingItems: Flow<PagingData<ChatUi>>,
    onSelectChat: (ChatUi) -> Unit,
    modifier: Modifier = Modifier,
) {
    val chats = chatsPagingItems.collectAsLazyPagingItems()

    if (chats.loadState.refresh == LoadState.Loading) {
        LoadingIndicator(48.dp, modifier = modifier.fillMaxSize())
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
        ) {
            items(
                count = chats.itemCount,
                key = chats.itemKey { it.id.value },
                contentType = { "item" }
            ) { index ->
                val chat = chats[index] ?: return@items
                ChatItem(chat = chat, onSelect = onSelectChat)
            }
        }
    }
}

@Preview
@Composable
private fun ChatsListPagingComponentPreview(
    @PreviewParameter(ChatsUiPagingDataParameterProvider::class) chats: Flow<PagingData<ChatUi>>,
) {
    AppTheme {
        ChatsListPagingComponent(
            chats,
            {},
        )
    }
}