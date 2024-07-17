package io.github.xlnk.telegramcopy.data.local.mapper

import androidx.annotation.ColorInt
import io.github.xlnk.telegramcopy.domain.entity.model.ImColor
import javax.inject.Inject

class ImColorDataMapper @Inject constructor() {

    fun toDomain(@ColorInt color: Int): ImColor = ImColor(color)

    @ColorInt
    fun toData(color: ImColor) = color.value
}