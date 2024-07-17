package io.github.xlnk.telegramcopy.domain.usecase

import androidx.paging.PagingData
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.repository.ChatWithDataRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetChatsPagingUseCase @Inject constructor(
//    private val chatWithDataToLocalMapper: ChatWithDataToLocalMapper,
//    private val chatDenormalizedDao: ChatDenormalizedDao,
    private val chatWithDataRepository: ChatWithDataRepository,
) {

//    operator fun invoke(): Flow<PagingData<ChatWithData>> = chatDenormalizedDao
//        .getChatsPagingData().map { pagingData ->
//            pagingData.map(chatWithDataToLocalMapper::toDomain)
//        }

    operator fun invoke(): Flow<PagingData<ChatWithData>> {
        return chatWithDataRepository.getChatsPagingData()
    }
}