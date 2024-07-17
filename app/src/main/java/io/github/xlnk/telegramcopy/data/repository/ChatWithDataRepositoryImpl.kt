package io.github.xlnk.telegramcopy.data.repository

import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.data.repository.datasource.ChatWithDataDataSource
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.repository.ChatWithDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ChatWithDataRepositoryImpl @Inject constructor(
    private val chatWithDataDataSource: ChatWithDataDataSource,
) : ChatWithDataRepository {

    override suspend fun saveChat(chat: ChatWithData) {
        chatWithDataDataSource.saveChat(chat)
    }

    override fun getChatsPagingData(): Flow<PagingData<ChatWithData>> {
        return chatWithDataDataSource.getChatsPagingData()
    }

    override suspend fun countChats(): Int = chatWithDataDataSource.countChats()
}