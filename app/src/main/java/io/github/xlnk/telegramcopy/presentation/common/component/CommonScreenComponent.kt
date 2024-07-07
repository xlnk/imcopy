package io.github.xlnk.telegramcopy.presentation.common.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CommonScreenComponent(
    snackbarState: SnackbarHostState,
    title: String,
    modifier: Modifier = Modifier,
    onBackRequest: (() -> Unit)? = null,
    content: @Composable (paddingsModifier: Modifier) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        snackbarHost = {
            SnackbarHost(hostState = snackbarState)
        },
        topBar = {

        }
    ) { innerPaddings ->
        content(Modifier.padding(innerPaddings))
    }
}