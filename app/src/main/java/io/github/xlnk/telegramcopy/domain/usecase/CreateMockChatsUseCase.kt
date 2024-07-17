package io.github.xlnk.telegramcopy.domain.usecase

import io.github.xlnk.telegramcopy.domain.repository.ChatWithDataRepository
import io.github.xlnk.telegramcopy.domain.strategy.ChatMockStrategy
import javax.inject.Inject

class CreateMockChatsUseCase @Inject constructor(
    private val chatMockStrategy: ChatMockStrategy,
    private val chatWithDataRepository: ChatWithDataRepository,
) {

    suspend operator fun invoke() {
        val count = chatWithDataRepository.countChats()
        if (count > 0) {
            return
        }
        val chats = chatMockStrategy.provideLotsOfChats(100)
        for (chat in chats) {
            chatWithDataRepository.saveChat(chat)
        }
    }
}