package io.github.xlnk.telegramcopy.data.local.mapper

import io.github.xlnk.telegramcopy.domain.entity.model.Sender
import javax.inject.Inject

class SenderDataMapper @Inject constructor() {

    fun toDomain(sender: String): Sender {
        return when (sender) {
            KEY_YOU -> Sender.You
            KEY_NOT_MATTER -> Sender.NotMatter
            else -> Sender.Other(sender)
        }
    }

    fun toData(sender: Sender): String = when (sender) {
        is Sender.You -> KEY_YOU
        is Sender.NotMatter -> KEY_NOT_MATTER
        is Sender.Other -> sender.shortName
    }

    companion object {

        private const val KEY_YOU = "####KEY_YOU####"
        private const val KEY_NOT_MATTER = "####KEY_NOT_MATTER####"
    }
}