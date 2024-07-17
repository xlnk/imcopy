package io.github.xlnk.telegramcopy.presentation.chats

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.xlnk.telegramcopy.domain.usecase.CreateMockChatsUseCase
import io.github.xlnk.telegramcopy.domain.usecase.GetChatsPagingUseCase
import io.github.xlnk.telegramcopy.domain.usecase.GetMockChatsPagingUseCase
import io.github.xlnk.telegramcopy.presentation.chats.mapper.ChatMapper
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
@HiltViewModel
class ChatsScreenViewModel @Inject constructor(
    getMockChatsPagingUseCase: GetMockChatsPagingUseCase,
    getChatsPagingUseCase: GetChatsPagingUseCase,
    createMockChatsUseCase: CreateMockChatsUseCase,
    private val chatMapper: ChatMapper,
) : ViewModel() {

    init {
        viewModelScope.launch {
            createMockChatsUseCase()
        }
    }

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

    val chatsPagingItemsFlow: Flow<PagingData<ChatUi>> = getChatsPagingUseCase()
        .map { pagingData ->
            pagingData.map(chatMapper::toPresentation)
        }
        .cachedIn(viewModelScope)
}