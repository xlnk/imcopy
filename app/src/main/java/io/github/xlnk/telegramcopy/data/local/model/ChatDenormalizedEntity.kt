package io.github.xlnk.telegramcopy.data.local.model

import androidx.annotation.ColorInt
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.xlnk.telegramcopy.domain.entity.model.ChatType
import java.time.LocalDateTime

@Entity(tableName = "chat_denormalized")
data class ChatDenormalizedEntity(
    @PrimaryKey val id: String,
    val name: String,
    @ColorInt
    @ColumnInfo("icon_placeholder_color")
    val iconPlaceholderColor: Int,
    @ColumnInfo(index = true)
    val pinned: Boolean,
    val muted: Boolean,
    val chatType: ChatType,
    @ColumnInfo("last_message_update", index = true)
    val lastMessageUpdate: LocalDateTime,
    val lastMessageText: String,
    val lastSender: String,
    val unreadMessagesCount: Int,
    val iconId: String?,
)