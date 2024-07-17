package io.github.xlnk.telegramcopy.common.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.xlnk.telegramcopy.common.strategy.PlaceholderLettersStrategy
import io.github.xlnk.telegramcopy.common.strategy.impl.PlaceholderLettersStrategyImpl

@Module
@InstallIn(SingletonComponent::class)
interface CommonModule {

    @Binds
    fun bindPlaceholderLettersStrategy(
        impl: PlaceholderLettersStrategyImpl
    ): PlaceholderLettersStrategy
}