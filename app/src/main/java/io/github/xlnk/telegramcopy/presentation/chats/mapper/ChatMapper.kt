package io.github.xlnk.telegramcopy.presentation.chats.mapper

import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi

class ChatMapper(
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