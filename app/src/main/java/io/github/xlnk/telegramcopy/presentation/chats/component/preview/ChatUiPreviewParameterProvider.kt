package io.github.xlnk.telegramcopy.presentation.chats.component.preview

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import io.github.xlnk.telegramcopy.domain.entity.model.DeliveryStatus
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.model.IconPlaceholderUi
import io.github.xlnk.telegramcopy.presentation.common.model.Sender
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDateTime

internal val chatFirst = ChatUi(
    EntityId("1"),
    IconPlaceholderUi(Color.Red, Color(0xFFF00000), "UO"),
    null,
    "User One",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    true,
    0,
    LocalDateTime.now(),
    true,
    Sender.NotMatter,
)

internal val chatSecond = ChatUi(
    EntityId("2"),
    IconPlaceholderUi(Color.Blue, Color(0xFF0000F0), "US"),
    null,
    "User Second",
    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
    false,
    29,
    LocalDateTime.now().minusDays(2),
    false,
)

internal val chatThird = ChatUi(
    EntityId("3"),
    IconPlaceholderUi(Color.Green, Color(0xFF00F000), "GT"),
    null,
    "Group title",
    "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
    false,
    99999,
    LocalDateTime.now().minusDays(10),
    false,
    lastMessageSender = Sender.You
)

internal val chatFourth = ChatUi(
    EntityId("4"),
    IconPlaceholderUi(Color(0xFFFFFF00), Color(0xFFF0F000), "TI"),
    null,
    "The very very very long title's text with a lot of different words in it",
    "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
    false,
    0,
    LocalDateTime.now().minusMonths(14),
    true,
    lastMessageSender = Sender.Other("User"),
    deliveryStatus = DeliveryStatus.Read,
)

class ChatUiPreviewParameterProvider : CollectionPreviewParameterProvider<ChatUi>(
    listOf(
        chatFirst,
        chatSecond,
        chatThird,
        chatFourth
    )
)

class ChatsUiPreviewParameterProvider : CollectionPreviewParameterProvider<ImmutableList<ChatUi>>(
    listOf(persistentListOf(chatFirst, chatSecond, chatThird, chatFourth))
)