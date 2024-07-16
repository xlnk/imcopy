package io.github.xlnk.telegramcopy.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.github.xlnk.telegramcopy.domain.entity.model.ChatType
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.domain.entity.model.IconId
import java.time.LocalDateTime

@Entity(tableName = "chat_denormalized")
data class ChatDenormalizedEntity(
    @PrimaryKey val id: String,
    val name: String,
    @ColumnInfo("placeholder_color")
    val placeholderColor: Long,
    @ColumnInfo(index = true)
    val pinned: Boolean,
    val muted: Boolean,
    val chatType: ChatType,
    @ColumnInfo("last_message_update", index = true)
    val lastMessageUpdate: LocalDateTime,
    val lastMessageText: String,
    val lastSenderName: String,
    val unreadMessagesCount: Int = 0,
    val iconId: String? = null,
)