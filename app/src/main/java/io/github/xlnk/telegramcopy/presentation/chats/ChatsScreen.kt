package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.chats.component.NewMessageFloatingButton
import io.github.xlnk.telegramcopy.presentation.chats.component.ChatsListPagingComponent
import io.github.xlnk.telegramcopy.presentation.chats.component.ChatsTopAppBar
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatsUiPagingDataParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.CommonScreenComponent
import io.github.xlnk.telegramcopy.presentation.common.extensions.showNotImplementedSnackbar
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun ChatsScreen(
    snackbarState: SnackbarHostState,
    onGoToChatRequest: (EntityId) -> Unit,
    onGoToNewMessageRequest: () -> Unit,
    selfViewModel: ChatsScreenViewModel = viewModel()
) {
    val composeCoroutineScope = rememberCoroutineScope()

    ChatsScreenContent(
        snackbarState = snackbarState,
        chatsPagingItems = selfViewModel.chatsPagingItemsFlow,
        onGoToChatRequest = { onGoToChatRequest(it.id) },
        onSearchRequest = {
            snackbarState.showNotImplementedSnackbar(composeCoroutineScope)
        },
        onGoToNewMessageRequest = onGoToNewMessageRequest,
    )
}

@Composable
private fun ChatsScreenContent(
    snackbarState: SnackbarHostState,
    chatsPagingItems: Flow<PagingData<ChatUi>>,
    onGoToChatRequest: (ChatUi) -> Unit,
    onSearchRequest: () -> Unit,
    onGoToNewMessageRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    CommonScreenComponent(
        snackbarState = snackbarState,
        topBar = { ChatsTopAppBar(onSearchRequest) },
        modifier = modifier,
        floatingActionButton = { NewMessageFloatingButton(onGoToNewMessageRequest) }
    ) { paddingsModifier ->
        ChatsListPagingComponent(
            chatsPagingItems = chatsPagingItems,
            onSelectChat = onGoToChatRequest,
            modifier = paddingsModifier,
        )
    }
}

@Preview
@Composable
private fun ChatsScreenContentPreview(
    @PreviewParameter(ChatsUiPagingDataParameterProvider::class) chats: Flow<PagingData<ChatUi>>
) {
    AppTheme {
        ChatsScreenContent(
            snackbarState = remember { SnackbarHostState() },
            chatsPagingItems = chats,
            {},
            {},
            {},
        )
    }
}