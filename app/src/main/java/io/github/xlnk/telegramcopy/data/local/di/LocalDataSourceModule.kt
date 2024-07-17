package io.github.xlnk.telegramcopy.data.local.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.xlnk.telegramcopy.data.datasource.ChatDataSource
import io.github.xlnk.telegramcopy.data.local.datasource.ChatDataSourceByRoom

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {

    @Binds
    fun bindChatDataSource(impl: ChatDataSourceByRoom): ChatDataSource
}