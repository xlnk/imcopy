package io.github.xlnk.telegramcopy.presentation.common.extensions

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import io.github.xlnk.telegramcopy.presentation.common.model.ImSnackbarVisuals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun SnackbarHostState.showNotImplementedSnackbar(coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        this@showNotImplementedSnackbar.showSnackbar(ImSnackbarVisuals.NotImplemented)
    }
}