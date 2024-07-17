package io.github.xlnk.telegramcopy.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import io.github.xlnk.telegramcopy.data.local.dao.ChatDenormalizedDao
import io.github.xlnk.telegramcopy.data.local.mapper.ChatDataMapper
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetChatsPagingUseCase(
    private val chatDataMapper: ChatDataMapper,
    private val chatDenormalizedDao: ChatDenormalizedDao,
) {

    operator fun invoke(): Flow<PagingData<ChatWithData>> = chatDenormalizedDao
        .getChatsPagingData().map { pagingData ->
            pagingData.map(chatDataMapper::toDomain)
        }
}