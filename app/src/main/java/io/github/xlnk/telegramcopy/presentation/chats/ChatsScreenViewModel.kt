package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.chatsPreviewData
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.utils.UiConstants.UI_FLOW_TIMEOUT
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

@Stable
class ChatsScreenViewModel : ViewModel() {

    private val mockData: ImmutableList<ChatUi> = List(30) {
        val chat = chatsPreviewData[it % chatsPreviewData.size]
        chat.copy(
            id = EntityId(chat.id.value + it),
            title = "${chat.title} $it"
        )
    }.toImmutableList()

    val chats: StateFlow<ImmutableList<ChatUi>?> = flow {
        delay(3000)
        emit(mockData)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(UI_FLOW_TIMEOUT),
        null
    )

    val chatsPagingItemsFlow: Flow<PagingData<ChatUi>> = flow {
        emit(PagingData.from(emptyList()))
        delay(3000)
        emit(PagingData.from(mockData, LoadStates(LoadState.NotLoading(false), LoadState.NotLoading(false), LoadState.NotLoading(false))))
    }
}