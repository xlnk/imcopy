package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.chats.component.ChatsListComponent
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.component.CommonScreenComponent
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
    )
}

@Composable
private fun ChatsScreenContent(
    snackbarState: SnackbarHostState,
    chats: ImmutableList<ChatUi>?,
    onGoToChatRequest: (ChatUi) -> Unit,
    modifier: Modifier = Modifier
) {
    CommonScreenComponent(
        snackbarState = snackbarState,
        modifier = modifier,
    ) { paddingsModifier ->
        ChatsListComponent(
            chats = chats ?: persistentListOf(),
            onSelectChat = onGoToChatRequest,
            modifier = paddingsModifier,
        )
    }
}
