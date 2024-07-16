package io.github.xlnk.telegramcopy.domain.entity.model

sealed interface Sender {

    data object NotMatter : Sender

    data object You : Sender

    @JvmInline
    value class Other(val shortName: String) : Sender
}