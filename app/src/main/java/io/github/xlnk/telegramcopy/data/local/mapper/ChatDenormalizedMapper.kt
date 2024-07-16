package io.github.xlnk.telegramcopy.data.local.mapper

import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId

class ChatDenormalizedMapper {

    fun toDomain(chat: ChatDenormalizedEntity): ChatWithData = ChatWithData(
        EntityId(chat.id),
        chat.name,
        chat.placeholderColor.toULong(),
        "",
        chat.pinned,
        chat.muted,
        chat.chatType,
        chat.lastMessageUpdate,
        chat.lastMessageText,
        chat.lastSenderName,
        chat.unreadMessagesCount,
        chat.iconId?.let { EntityId(it) }
    )
}