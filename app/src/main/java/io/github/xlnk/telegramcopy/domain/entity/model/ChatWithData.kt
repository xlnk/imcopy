package io.github.xlnk.telegramcopy.domain.entity.model

import java.time.LocalDateTime

data class ChatWithData(
    val id: EntityId,
    val name: String,
    val placeholderColor: ImColor,
    val placeholderLetters: String,
    val pinned: Boolean,
    val muted: Boolean,
    val chatType: ChatType,
    val lastMessageUpdate: LocalDateTime,
    val lastMessageText: String,
    val lastSenderName: String,
    val unreadMessagesCount: Int,
    val iconId: EntityId?,
)
