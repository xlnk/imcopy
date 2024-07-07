package io.github.xlnk.telegramcopy.presentation.common.model

import androidx.compose.ui.graphics.ImageBitmap
import io.github.xlnk.telegramcopy.domain.entity.model.CommonHash

data class ImBitmapUi(
    val hash: CommonHash,
    val bitmap: ImageBitmap,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ImBitmapUi

        return hash == other.hash
    }

    override fun hashCode(): Int {
        return hash.hashCode()
    }
}
