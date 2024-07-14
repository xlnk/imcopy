package io.github.xlnk.telegramcopy.presentation.common.model

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals

sealed class ImSnackbarVisuals(
    override val duration: SnackbarDuration,
    override val withDismissAction: Boolean = false,
    override val actionLabel: String? = null,
    override val message: String = "",
) : SnackbarVisuals {

    data object NotImplemented : ImSnackbarVisuals(
        duration = SnackbarDuration.Short,
        withDismissAction = true,
        message = "Not implemented",
    )
}