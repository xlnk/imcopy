package io.github.xlnk.telegramcopy.presentation.chats.model

import io.github.xlnk.telegramcopy.domain.entity.model.DeliveryStatus
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.common.model.IconPlaceholderUi
import io.github.xlnk.telegramcopy.presentation.common.model.ImBitmapUi
import io.github.xlnk.telegramcopy.presentation.common.model.Sender
import java.time.LocalDateTime

data class ChatUi(
    val id: EntityId,
    val iconPlaceholder: IconPlaceholderUi,
    val icon: ImBitmapUi?,
    val title: String,
    val lastMessage: String,
    val pinned: Boolean,
    val unreadMessagesCount: Int,
    val lastMessageUpdated: LocalDateTime,
    val muted: Boolean,
    val lastMessageSender: Sender = Sender.NotMatter,
    val deliveryStatus: DeliveryStatus = DeliveryStatus.None
)
