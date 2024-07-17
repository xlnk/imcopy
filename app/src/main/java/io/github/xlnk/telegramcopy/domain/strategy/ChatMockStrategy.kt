package io.github.xlnk.telegramcopy.domain.strategy

import io.github.xlnk.telegramcopy.domain.entity.model.ChatWithData
import kotlinx.collections.immutable.ImmutableList

interface ChatMockStrategy {

    fun provideChats(): List<ChatWithData>

    fun provideLotsOfChats(count: Int): ImmutableList<ChatWithData>
}