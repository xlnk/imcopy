package io.github.xlnk.telegramcopy.data.repository

import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.data.datasource.ChatDataSource
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.repository.ChatWithDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatWithDataRepositoryImpl @Inject constructor(
    private val chatDataSource: ChatDataSource,
) : ChatWithDataRepository {

    override suspend fun saveChat(chat: ChatWithData) {
        chatDataSource.saveChat(chat)
    }

    override fun getChatsPagingData(): Flow<PagingData<ChatWithData>> {
        return chatDataSource.getChatsPagingData()
    }
}