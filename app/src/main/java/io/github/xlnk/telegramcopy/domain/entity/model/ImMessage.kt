package io.github.xlnk.telegramcopy.domain.entity.model

import java.time.ZonedDateTime

data class ImMessage(
    val id: EntityId,
    val text: String,
    val date: ZonedDateTime,
    val chatId: EntityId,
)
