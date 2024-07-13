package io.github.xlnk.telegramcopy.presentation.app

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import io.github.xlnk.telegramcopy.presentation.chats.ChatsScreen
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme

@Composable
fun AppComponent(modifier: Modifier = Modifier) {
    val snackbarState = remember { SnackbarHostState() }



    AppTheme {
        ChatsScreen(
            snackbarState = snackbarState,
            onGoToChatRequest = {

            },
        )
    }
}