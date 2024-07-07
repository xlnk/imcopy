package io.github.xlnk.telegramcopy.domain.entity.model

interface WithOptionalIcon {
    val iconId: EntityId?
    val placeholderColor: ImColor
}