package io.github.xlnk.telegramcopy.domain.entity.model

import java.time.ZonedDateTime

sealed class ImBaseChat : WithOptionalIcon {
    abstract val id: EntityId
    abstract val muteUntil: ZonedDateTime?
    abstract val name: String
    abstract val pinned: Boolean
    abstract val unreadMessagesCount: Int
    abstract val lastUpdated: ZonedDateTime
    abstract override val iconId: EntityId?
    abstract override val placeholderColor: ImColor
}

data class ImChatWithUser(
    override val id: EntityId,
    override val muteUntil: ZonedDateTime?,
    override val pinned: Boolean = false,
    override val unreadMessagesCount: Int,
    override val lastUpdated: ZonedDateTime,
    val user: ImUser
) : ImBaseChat() {

    override val name: String
        get() = user.name

    override val placeholderColor: ImColor
        get() = user.placeholderColor

    override val iconId: EntityId?
        get() = user.iconId
}

data class ImGroup(
    override val id: EntityId,
    override val muteUntil: ZonedDateTime?,
    override val name: String,
    override val pinned: Boolean = false,
    override val unreadMessagesCount: Int,
    override val iconId: EntityId?,
    override val placeholderColor: ImColor,
    override val lastUpdated: ZonedDateTime,
    val memberCount: Int,
) : ImBaseChat()