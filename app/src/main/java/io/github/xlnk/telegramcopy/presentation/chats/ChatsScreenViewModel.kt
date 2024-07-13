package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.chatFirst
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.chatFourth
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.chatSecond
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.chatThird
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.utils.UiConstants.UI_FLOW_TIMEOUT
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@Stable
class ChatsScreenViewModel : ViewModel() {

    val chats: StateFlow<ImmutableList<ChatUi>?> = flow {
        delay(3000)
        emit(persistentListOf(
            chatFirst,
            chatSecond,
            chatThird,
            chatFourth,
        ))
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(UI_FLOW_TIMEOUT),
        null
    )
}