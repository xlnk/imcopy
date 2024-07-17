package io.github.xlnk.telegramcopy.data.local.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.xlnk.telegramcopy.data.repository.datasource.ChatWithDataDataSource
import io.github.xlnk.telegramcopy.data.local.datasource.ChatWithDataDataSourceByRoom

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {

    @Binds
    fun bindChatDataSource(impl: ChatWithDataDataSourceByRoom): ChatWithDataDataSource
}