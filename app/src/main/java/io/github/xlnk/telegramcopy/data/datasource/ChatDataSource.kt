package io.github.xlnk.telegramcopy.data.datasource

import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import kotlinx.coroutines.flow.Flow

interface ChatDataSource {

    suspend fun saveChat(chat: ChatWithData)

    fun getChatsPagingData(): Flow<PagingData<ChatWithData>>

    suspend fun countChats(): Int
}