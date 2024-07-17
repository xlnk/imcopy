package io.github.xlnk.telegramcopy.data.local.mapper

import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import javax.inject.Inject

class ChatDataMapper @Inject constructor(
    private val imColorDataMapper: ImColorDataMapper,
    private val senderDataMapper: SenderDataMapper,
    private val entityIdDataMapper: EntityIdDataMapper,
) {

    fun toDomain(chat: ChatDenormalizedEntity): ChatWithData = ChatWithData(
        entityIdDataMapper.toDomain(chat.id),
        chat.name,
        imColorDataMapper.toDomain(chat.iconPlaceholderColor),
        chat.pinned,
        chat.muted,
        chat.lastMessageUpdate,
        chat.lastMessageText,
        senderDataMapper.toDomain(chat.lastSender),
        chat.unreadMessagesCount,
        chat.iconId?.let(entityIdDataMapper::toDomain)
    )
}