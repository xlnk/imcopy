package io.github.xlnk.telegramcopy.data.local.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.xlnk.telegramcopy.data.local.database.AppDatabase
import io.github.xlnk.telegramcopy.data.local.database.AppDatabaseFactory

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    internal fun provideAppDatabase(@ApplicationContext context: Context) =
        AppDatabaseFactory().create(context)

    @Provides
    internal fun provideChatDenormalizedDao(database: AppDatabase) = database
        .chatDenormalizedDao()
}