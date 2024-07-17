package io.github.xlnk.telegramcopy.data.repository.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.xlnk.telegramcopy.data.repository.ChatWithDataRepositoryImpl
import io.github.xlnk.telegramcopy.domain.repository.ChatWithDataRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindChatWithDataRepository(impl: ChatWithDataRepositoryImpl): ChatWithDataRepository
}