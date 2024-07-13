package io.github.xlnk.telegramcopy.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.xlnk.telegramcopy.presentation.common.extensions.toDp
import io.github.xlnk.telegramcopy.presentation.common.theme.AppTheme

@Composable
fun UnreadCountComponent(
    count: Int,
    size: TextUnit,
    modifier: Modifier = Modifier,
    isHighlighted: Boolean = false,
) {
    val backgroundColor: Color
    val textColor: Color
    if (isHighlighted) {
        backgroundColor = MaterialTheme.colorScheme.primary
        textColor = MaterialTheme.colorScheme.onPrimary
    } else {
        backgroundColor = MaterialTheme.colorScheme.tertiary
        textColor = MaterialTheme.colorScheme.onTertiary
    }
    val width = size.toDp()
    Box(
        modifier = modifier
            .widthIn(min = width)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = count.toString(),
            color = textColor,
//            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 4.dp),
            lineHeight = size,
            fontSize = size.div(2),
        )
    }
}

@Preview
@Composable
private fun UnreadCountComponentPreview() {
    AppTheme {
        UnreadCountComponent(299, 20.sp)
    }
}

@Preview
@Composable
private fun UnreadCountComponentPreviewHighlighted() {
    AppTheme {
        UnreadCountComponent(3, 20.sp, isHighlighted = true)
    }
}