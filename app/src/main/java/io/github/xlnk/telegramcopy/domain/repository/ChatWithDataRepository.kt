package io.github.xlnk.telegramcopy.domain.repository

import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import kotlinx.coroutines.flow.Flow

interface ChatWithDataRepository {

    suspend fun saveChat(chat: ChatWithData)
    fun getChatsPagingData(): Flow<PagingData<ChatWithData>>
}