package io.github.xlnk.telegramcopy.common.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.xlnk.telegramcopy.common.strategy.CoroutineScopeProvider
import io.github.xlnk.telegramcopy.common.strategy.DispatcherProvider
import io.github.xlnk.telegramcopy.common.strategy.PlaceholderLettersStrategy
import io.github.xlnk.telegramcopy.common.strategy.impl.CoroutineScopeProviderImpl
import io.github.xlnk.telegramcopy.common.strategy.impl.DispatcherProviderImpl
import io.github.xlnk.telegramcopy.common.strategy.impl.PlaceholderLettersStrategyImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CommonModule {

    @Binds
    fun bindPlaceholderLettersStrategy(
        impl: PlaceholderLettersStrategyImpl
    ): PlaceholderLettersStrategy

    @Binds
    fun bindDispatcherProvider(impl: DispatcherProviderImpl): DispatcherProvider

    @Binds
    @Singleton
    fun bindCoroutineScopeProvider(impl: CoroutineScopeProviderImpl): CoroutineScopeProvider
}