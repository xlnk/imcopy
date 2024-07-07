package io.github.xlnk.telegramcopy.domain.entity.model

data class ImUser(
    val id: EntityId,
    val firstName: String,
    val lastName: String,
    override val iconId: EntityId?,
    override val placeholderColor: ImColor,
) : WithOptionalIcon {

    val name: String get() = "$firstName $lastName"
}
