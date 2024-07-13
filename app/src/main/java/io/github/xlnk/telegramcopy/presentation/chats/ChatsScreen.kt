package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.chats.component.ChatsListComponent
import io.github.xlnk.telegramcopy.presentation.chats.component.ChatsTopAppBar
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.ChatsUiPreviewParameterProvider
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.CommonScreenComponent
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun ChatsScreen(
    snackbarState: SnackbarHostState,
    onGoToChatRequest: (EntityId) -> Unit,
    selfViewModel: ChatsScreenViewModel = viewModel()
) {
    ChatsScreenContent(
        snackbarState = snackbarState,
        chats = selfViewModel.chats.collectAsStateWithLifecycle().value,
        onGoToChatRequest = { onGoToChatRequest(it.id) },
        onSearchRequest = {},
    )
}

@Composable
private fun ChatsScreenContent(
    snackbarState: SnackbarHostState,
    chats: ImmutableList<ChatUi>?,
    onGoToChatRequest: (ChatUi) -> Unit,
    onSearchRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    CommonScreenComponent(
        snackbarState = snackbarState,
        topBar = { ChatsTopAppBar(onSearchRequest) },
        modifier = modifier,
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
        )
    }
}