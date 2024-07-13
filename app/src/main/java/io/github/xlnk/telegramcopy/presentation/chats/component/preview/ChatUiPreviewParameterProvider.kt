package io.github.xlnk.telegramcopy.presentation.chats.component.preview

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import io.github.xlnk.telegramcopy.domain.entity.model.EntityId
import io.github.xlnk.telegramcopy.presentation.chats.model.ChatUi
import io.github.xlnk.telegramcopy.presentation.common.model.IconPlaceholderUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDateTime
import java.time.ZonedDateTime

private val chatFirst = ChatUi(
    EntityId("1"),
    IconPlaceholderUi(Color.Red, Color(0xFFF00000), "UO"),
    null,
    "User One",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
    true,
    10,
    LocalDateTime.now(),
    true,
)

private val chatSecond = ChatUi(
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

class ChatUiPreviewParameterProvider : CollectionPreviewParameterProvider<ChatUi>(
    listOf(
        chatFirst,
        chatSecond
    )
)

class ChatsUiPreviewParameterProvider : CollectionPreviewParameterProvider<ImmutableList<ChatUi>>(
    listOf(persistentListOf(chatFirst, chatSecond))
)