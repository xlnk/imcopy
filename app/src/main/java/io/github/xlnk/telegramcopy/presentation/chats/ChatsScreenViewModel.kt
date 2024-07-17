package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.domain.usecase.GetMockChatsPagingUseCase
import io.github.xlnk.telegramcopy.presentation.chats.component.preview.chatsPreviewData
import io.github.xlnk.telegramcopy.presentation.chats.mapper.ChatMapper
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.utils.UiConstants.UI_FLOW_TIMEOUT
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@Stable
@HiltViewModel
class ChatsScreenViewModel @Inject constructor(
    getMockChatsPagingUseCase: GetMockChatsPagingUseCase,
    private val chatMapper: ChatMapper,
) : ViewModel() {

//    private val mockData: ImmutableList<ChatUi> = List(30) {
//        val chat = chatsPreviewData[it % chatsPreviewData.size]
//        chat.copy(
//            id = EntityId(chat.id.value + it),
//            name = "${chat.name} $it"
//        )
//    }.toImmutableList()
//
//    val chats: StateFlow<ImmutableList<ChatUi>?> = flow {
//        delay(3000)
//        emit(mockData)
//    }.stateIn(
//        viewModelScope,
//        SharingStarted.WhileSubscribed(UI_FLOW_TIMEOUT),
//        null
//    )

    val chatsPagingItemsFlow: Flow<PagingData<ChatUi>> = getMockChatsPagingUseCase()
        .map { pagingData ->
            pagingData.map(chatMapper::toPresentation)
        }
}