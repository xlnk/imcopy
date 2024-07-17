package io.github.xlnk.telegramcopy.common.strategy

import kotlinx.coroutines.CoroutineScope

interface CoroutineScopeProvider {

    val appScope: CoroutineScope
}