package io.github.xlnk.telegramcopy.presentation.common.component

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.xlnk.telegramcopy.presentation.common.model.ImSnackbarVisuals

@Composable
fun ImSnackbarHost(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier,
) {
    SnackbarHost(hostState = hostState, modifier = modifier) { snackbarData ->
        when (val visuals = snackbarData.visuals) {
            is ImSnackbarVisuals.NotImplemented -> {
                
            }
            else -> {
                Snackbar(snackbarData = snackbarData)
            }
        }
    }
}