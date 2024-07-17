package io.github.xlnk.telegramcopy.presentation.chats.mapper

import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import javax.inject.Inject

class ChatMapper @Inject constructor(
    private val iconPlaceholderMapper: IconPlaceholderMapper,
) {

    fun toPresentation(chat: ChatWithData): ChatUi = ChatUi(
        chat.id,
        iconPlaceholderMapper.toPresentation(chat.iconPlaceholderColor, chat.iconPlaceholderLetters),
        null,
        chat.name,
        chat.lastMessageText,
        chat.pinned,
        chat.unreadMessagesCount,
        chat.lastMessageUpdate,
        chat.muted,
    )
}