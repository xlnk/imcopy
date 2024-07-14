package io.github.xlnk.telegramcopy.presentation.chats.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.xlnk.telegramcopy.R
import io.github.xlnk.telegramcopy.presentation.common.component.ImFloatingButton

@Composable
internal fun NewMessageFloatingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ImFloatingButton(
        onClick = onClick,
        imageVector = Icons.Default.Edit,
        contentDescriptionId = R.string.new_message_description_text,
        modifier = modifier,
    )
}