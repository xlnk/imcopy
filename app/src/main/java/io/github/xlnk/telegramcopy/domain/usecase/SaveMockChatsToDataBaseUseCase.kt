package io.github.xlnk.telegramcopy.domain.usecase

import io.github.xlnk.telegramcopy.domain.repository.ChatWithDataRepository
import io.github.xlnk.telegramcopy.domain.strategy.ChatMockStrategy
import javax.inject.Inject

class SaveMockChatsToDataBaseUseCase @Inject constructor(
    private val chatMockStrategy: ChatMockStrategy,
    private val chatWithDataRepository: ChatWithDataRepository,
) {

    suspend operator fun invoke(count: Int) {
        val chats = chatMockStrategy.provideLotsOfChats(count)
        for (chat in chats) {
            chatWithDataRepository.saveChat(chat)
        }
    }
}