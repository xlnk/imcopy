package io.github.xlnk.telegramcopy.presentation.common.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
@ReadOnlyComposable
fun Dp.toSp(): TextUnit = with(LocalDensity.current) {
    this@toSp.toSp()
}

@Composable
@ReadOnlyComposable
fun TextUnit.toDp(): Dp = with(LocalDensity.current) {
    this@toDp.toDp()
}