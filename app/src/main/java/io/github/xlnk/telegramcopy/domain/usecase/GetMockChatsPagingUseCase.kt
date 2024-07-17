package io.github.xlnk.telegramcopy.domain.usecase

import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.strategy.ChatMockStrategy
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMockChatsPagingUseCase @Inject constructor(
    private val chatMockStrategy: ChatMockStrategy,
) {

    private val notLoadingState = LoadState.NotLoading(false)

    operator fun invoke(): Flow<PagingData<ChatWithData>> = flow {
        emit(PagingData.from(emptyList()))
        delay(3000)
        emit(
            PagingData.from(
                chatMockStrategy.provideLotsOfChats(50),
                LoadStates(notLoadingState, notLoadingState, notLoadingState)
            )
        )
    }
}