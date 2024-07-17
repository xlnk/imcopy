package io.github.xlnk.telegramcopy.domain.entity.model

import java.time.LocalDateTime

data class ChatWithData(
    val id: EntityId,
    val name: String,
    val iconPlaceholderColor: ImColor,
    val pinned: Boolean,
    val muted: Boolean,
    val lastMessageUpdate: LocalDateTime,
    val lastMessageText: String,
    val lastSender: Sender,
    val unreadMessagesCount: Int,
    val iconId: EntityId? = null,
    val chatType: ChatType = ChatType.OneToOne,
    val iconPlaceholderLetters: String = "",
)
