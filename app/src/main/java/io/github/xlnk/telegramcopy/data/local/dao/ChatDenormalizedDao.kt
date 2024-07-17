package io.github.xlnk.telegramcopy.data.local.dao

import androidx.annotation.WorkerThread
import androidx.compose.ui.graphics.Color
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.entity.model.DeliveryStatus
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.domain.entity.model.Sender
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.model.IconPlaceholderUi
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
abstract class ChatDenormalizedDao {

    @Query("SELECT * FROM chat_denormalized ORDER BY pinned DESC, last_message_update DESC")
    abstract fun getChatsPagingSource(): PagingSource<Int, ChatDenormalizedEntity>

    @WorkerThread
    @Upsert
    abstract suspend fun save(chat: ChatDenormalizedEntity)

    @Query("SELECT COUNT(id) FROM chat_denormalized")
    abstract suspend fun countChats(): Int

//    fun getChatsPagingData(): Flow<PagingData<ChatDenormalizedEntity>> {
//        return Pager(
//            config = PAGING_CONFIG,
//            pagingSourceFactory = {
//                getChatsPagingSource()
//            }
//        ).flow
//    }


}