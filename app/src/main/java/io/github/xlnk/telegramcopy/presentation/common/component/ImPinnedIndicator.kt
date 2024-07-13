package io.github.xlnk.telegramcopy.presentation.common.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkAdded
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme

@Composable
fun ImPinnedIndicator(
    size: Dp,
    modifier: Modifier = Modifier,
) {
    val color = MaterialTheme.colorScheme.onSurfaceVariant
    Box(
        modifier = modifier
            .size(size)
            .border(1.dp, color, CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.BookmarkAdded,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(size.div(2))
        )
    }
}

@Preview
@Composable
private fun ImPinnedIndicatorPreview() {
    AppTheme {
        ImPinnedIndicator(20.dp)
    }
}