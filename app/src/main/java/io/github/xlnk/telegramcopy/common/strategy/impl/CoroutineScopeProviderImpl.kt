package io.github.xlnk.telegramcopy.common.strategy.impl

import io.github.xlnk.telegramcopy.common.strategy.CoroutineScopeProvider
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.plus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoroutineScopeProviderImpl @Inject constructor() : CoroutineScopeProvider {

    override val appScope: CoroutineScope = MainScope() + CoroutineName("ApplicationScope")
}