package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.chats.component.NewMessageFloatingButton
import io.github.xlnk.telegramcopy.presentation.chats.component.ChatsListComponent
import io.github.xlnk.telegramcopy.presentation.chats.component.ChatsTopAppBar
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatsUiPreviewParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.CommonScreenComponent
import io.github.xlnk.telegramcopy.presentation.common.extensions.showNotImplementedSnackbar
import io.github.xlnk.telegramcopy.presentation.common.model.ImSnackbarVisuals
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch

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
        chats = selfViewModel.chats.collectAsStateWithLifecycle().value,
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
    chats: ImmutableList<ChatUi>?,
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
        ChatsListComponent(
            chats = chats ?: persistentListOf(),
            onSelectChat = onGoToChatRequest,
            modifier = paddingsModifier,
        )
    }
}

@Preview
@Composable
private fun ChatsScreenContentPreview(
    @PreviewParameter(ChatsUiPreviewParameterProvider::class) chats: ImmutableList<ChatUi>
) {
    AppTheme {
        ChatsScreenContent(
            snackbarState = remember { SnackbarHostState() },
            chats = chats,
            {},
            {},
            {},
        )
    }
}