package io.github.xlnk.telegramcopy.data.local.mapper

import io.github.xlnk.telegramcopy.common.strategy.PlaceholderLettersStrategy
import io.github.xlnk.telegramcopy.data.local.model.ChatDenormalizedEntity
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import javax.inject.Inject

class ChatWithDataToLocalMapper @Inject constructor(
    private val imColorDataMapper: ImColorDataMapper,
    private val senderDataMapper: SenderDataMapper,
    private val entityIdDataMapper: EntityIdDataMapper,
    private val placeholderLettersStrategy: PlaceholderLettersStrategy
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
        chat.iconId?.let(entityIdDataMapper::toDomain),
        chatType = chat.chatType,
        iconPlaceholderLetters = placeholderLettersStrategy.extractLetters(chat.name)
    )

    fun toData(chat: ChatWithData) = ChatDenormalizedEntity(
        entityIdDataMapper.toData(chat.id),
        chat.name,
        imColorDataMapper.toData(chat.iconPlaceholderColor),
        chat.pinned,
        chat.muted,
        chat.chatType,
        chat.lastMessageUpdate,
        chat.lastMessageText,
        senderDataMapper.toData(chat.lastSender),
        chat.unreadMessagesCount,
        chat.iconId?.let(entityIdDataMapper::toData),
    )
}