package io.github.xlnk.telegramcopy.data.local.dao

import androidx.annotation.WorkerThread
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ChatDenormalizedDao {

    @Query("SELECT * FROM chat_denormalized ORDER BY pinned DESC, last_message_update DESC")
    abstract fun getChatsPagingSource(): PagingSource<Int, ChatDenormalizedEntity>

    @WorkerThread
    @Upsert
    abstract suspend fun save(chat: ChatDenormalizedEntity)

    fun getChatsPagingData(): Flow<PagingData<ChatDenormalizedEntity>> {
        return Pager(
            config = PAGING_CONFIG,
            pagingSourceFactory = {
                getChatsPagingSource()
            }
        ).flow
    }

    companion object {

        private const val PAGING_PAGE_SIZE = 20
        private const val PAGING_PREFETCH_DISTANCE = PAGING_PAGE_SIZE
        private const val PAGING_HELD_ITEMS = PAGING_PAGE_SIZE * 2 + PAGING_PREFETCH_DISTANCE * 2
        private const val PAGING_JUMP_THRESHOLD = PAGING_PAGE_SIZE * 3 + PAGING_PREFETCH_DISTANCE * 3

        private val PAGING_CONFIG = PagingConfig(
            pageSize = PAGING_PAGE_SIZE,
            prefetchDistance = PAGING_PREFETCH_DISTANCE,
            enablePlaceholders = true,
            maxSize = PAGING_HELD_ITEMS,
            jumpThreshold = PAGING_JUMP_THRESHOLD,
        )
    }
}