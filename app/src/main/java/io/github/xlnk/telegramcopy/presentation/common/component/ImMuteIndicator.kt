package io.github.xlnk.telegramcopy.presentation.common.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ImMuteIndicator(
    modifier: Modifier = Modifier,
    size: Dp = 16.dp,
) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.VolumeOff,
        contentDescription = null,
        modifier = modifier.size(size),
    )
}