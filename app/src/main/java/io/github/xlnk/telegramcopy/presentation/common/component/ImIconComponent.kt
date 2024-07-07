package io.github.xlnk.telegramcopy.presentation.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.xlnk.telegramcopy.presentation.common.extensions.toSp
import io.github.xlnk.telegramcopy.presentation.common.model.ImBitmapUi
import io.github.xlnk.telegramcopy.presentation.common.model.IconPlaceholderUi

@Composable
fun ImIconComponent(
    icon: ImBitmapUi?,
    placeholderColor: IconPlaceholderUi,
    size: Dp,
    modifier: Modifier = Modifier
) {
    if (icon != null) {
        Image(
            bitmap = icon.bitmap,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .size(size)
                .clip(CircleShape)
        )
    } else {
        IconPlaceholder(placeholderColor, size, modifier)
    }
}

@Composable
private fun IconPlaceholder(
    placeholder: IconPlaceholderUi,
    size: Dp,
    modifier: Modifier = Modifier
) {
    val brush = remember(placeholder) {
        Brush.verticalGradient(listOf(placeholder.startColor, placeholder.endColor))
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(brush)
    ) {
        val textSize = size.toSp() / 3
        Text(
            text = placeholder.letters,
            color = Color.White,
            fontSize = textSize,
        )
    }
}

@Preview
@Composable
private fun IconPlaceholderPreview() {
    IconPlaceholder(
        IconPlaceholderUi(Color(0xFF0000FF), Color(0xFF0000C0), "AB"),
        40.dp,
    )
}