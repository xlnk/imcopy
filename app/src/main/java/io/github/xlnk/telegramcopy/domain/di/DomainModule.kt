package io.github.xlnk.telegramcopy.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.xlnk.telegramcopy.domain.strategy.ChatMockStrategy
import io.github.xlnk.telegramcopy.domain.strategy.impl.ChatMockStrategyImpl

@Module
@InstallIn(SingletonComponent::class)
interface DomainModule {

    @Binds
    fun bindChatMockStrategy(impl: ChatMockStrategyImpl): ChatMockStrategy
}