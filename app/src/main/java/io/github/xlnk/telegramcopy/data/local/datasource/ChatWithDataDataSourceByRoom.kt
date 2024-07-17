package io.github.xlnk.telegramcopy.data.local.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import io.github.xlnk.telegramcopy.common.strategy.DispatcherProvider
import io.github.xlnk.telegramcopy.data.repository.datasource.ChatWithDataDataSource
import io.github.xlnk.telegramcopy.data.local.dao.ChatDenormalizedDao
import io.github.xlnk.telegramcopy.data.local.mapper.ChatWithDataToLocalMapper
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChatWithDataDataSourceByRoom @Inject constructor(
    private val chatDenormalizedDao: ChatDenormalizedDao,
    private val chatWithDataToLocalMapper: ChatWithDataToLocalMapper,
    private val dispatcherProvider: DispatcherProvider,
) : ChatWithDataDataSource {

    override suspend fun saveChat(chat: ChatWithData) {
        withContext(dispatcherProvider.io) {
            chatDenormalizedDao.save(chatWithDataToLocalMapper.toData(chat))
        }
    }

    override fun getChatsPagingData(): Flow<PagingData<ChatWithData>> =
        Pager(
            config = PAGING_CONFIG,
            pagingSourceFactory = {
                chatDenormalizedDao.getChatsPagingSource()
            }
        )
            .flow
            .map { pagingData ->
                pagingData.map(chatWithDataToLocalMapper::toDomain)
            }

    override suspend fun countChats(): Int = withContext(dispatcherProvider.io) {
        chatDenormalizedDao.countChats()
    }

    companion object {

        private const val PAGING_PAGE_SIZE = 15
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