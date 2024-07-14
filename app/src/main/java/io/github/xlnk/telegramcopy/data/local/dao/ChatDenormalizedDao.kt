package io.github.xlnk.telegramcopy.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity

@Dao
internal abstract class ChatDenormalizedDao {

    @Query("SELECT * FROM chat_denormalized ORDER BY pinned DESC, last_message_update DESC")
    abstract fun getChatsPagingSource(): PagingSource<Int, ChatDenormalizedEntity>

    @Upsert
    abstract suspend fun save(chat: ChatDenormalizedEntity)
}