package io.github.xlnk.telegramcopy.presentation.common.model

sealed interface Sender {

    data object NotMatter : Sender

    data object You : Sender

    @JvmInline
    value class Other(val shortName: String) : Sender
}