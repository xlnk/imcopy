package io.github.xlnk.telegramcopy.domain.strategy.impl

import io.github.xlnk.telegramcopy.common.strategy.PlaceholderLettersStrategy
import io.github.xlnk.telegramcopy.domain.entity.model.ChatType
import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.domain.entity.model.ImColor
import io.github.xlnk.telegramcopy.domain.entity.model.Sender
import kotlinx.collections.immutable.ImmutableList
import java.time.LocalDateTime
import javax.inject.Inject

class ChatMockStrategyImpl @Inject constructor(
    private val placeholderLettersStrategy: PlaceholderLettersStrategy,
) {

    fun provideChats(): List<ChatWithData> {
        return listOf(
            chatFirst,
            chatSecond,
            chatThird,
            chatFourth,
        ).map {
            it.copy(
                iconPlaceholderLetters = placeholderLettersStrategy.extractLetters(it.name)
            )
        }
    }

    fun provideLotsOfChats(count: Int): List<ChatWithData> {
        val chats = provideChats()
        val mockCount = chats.size
        return List(count) {
            val chat = chats[mockCount]
            chat.copy(
                id = EntityId(chat.id.value + " $it"),
                name = "${chat.name} $it",
            )
        }
    }
}

private val chatFirst = ChatWithData(
    id = EntityId("1"),
    iconPlaceholderColor = ImColor(0xFFFF0000L.toInt()),
    iconId = null,
    name = "User One",
    lastMessageText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    pinned = true,
    unreadMessagesCount = 0,
    lastMessageUpdate = LocalDateTime.now(),
    muted = true,
    lastSender = Sender.NotMatter,
    iconPlaceholderLetters = "",
)

private val chatSecond = ChatWithData(
    id = EntityId("2"),
    iconPlaceholderColor = ImColor(0xFF00FF00L.toInt()),
    iconId = null,
    name = "User Second",
    lastMessageText = "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    pinned = false,
    unreadMessagesCount = 29,
    lastMessageUpdate = LocalDateTime.now().minusDays(2),
    muted = false,
    iconPlaceholderLetters = "",
    lastSender = Sender.You,
    chatType = ChatType.OneToOne,
)

private val chatThird = ChatWithData(
    id = EntityId("3"),
    iconPlaceholderColor = ImColor(0xFF0000FFL.toInt()),
    iconId = null,
    name = "Group title",
    lastMessageText = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
    pinned = false,
    unreadMessagesCount = 99999,
    lastMessageUpdate = LocalDateTime.now().minusDays(10),
    muted = false,
    lastSender = Sender.You,
    iconPlaceholderLetters = "",
)

private val chatFourth = ChatWithData(
    id = EntityId("4"),
    iconPlaceholderColor = ImColor(0xFFFFFF00L.toInt()),
    iconId = null,
    name = "The very very very long title's text with a lot of different words in it",
    lastMessageText = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
    pinned = false,
    unreadMessagesCount = 0,
    lastMessageUpdate = LocalDateTime.now().minusMonths(14),
    muted = true,
    lastSender = Sender.Other("User"),
    iconPlaceholderLetters = "",
)