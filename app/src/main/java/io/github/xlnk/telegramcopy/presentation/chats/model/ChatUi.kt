package io.github.xlnk.telegramcopy.presentation.chats.model

import io.github.xlnk.telegramcopy.domain.entity.model.DeliveryStatus
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.domain.entity.model.ImBaseChat
import io.github.xlnk.telegramcopy.presentation.common.model.IconPlaceholderUi
import io.github.xlnk.telegramcopy.presentation.common.model.ImBitmapUi
import io.github.xlnk.telegramcopy.presentation.common.model.Sender
import java.time.LocalDateTime
import java.time.ZonedDateTime

data class ChatUi(
//    val chat: ImBaseChat,
    val id: EntityId,
    val iconPlaceholder: IconPlaceholderUi,
    val icon: ImBitmapUi?,
    val title: String,
    val lastMessage: String,
    val isPinned: Boolean,
    val unreadMessagesCount: Int,
    val lastUpdated: LocalDateTime,
    val muted: Boolean,
    val lastMessageSender: Sender = Sender.NotMatter,
    val deliveryStatus: DeliveryStatus = DeliveryStatus.None
)
