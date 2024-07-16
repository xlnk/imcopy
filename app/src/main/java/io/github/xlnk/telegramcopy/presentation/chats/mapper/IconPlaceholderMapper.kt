package io.github.xlnk.telegramcopy.presentation.chats.mapper

import androidx.compose.ui.graphics.Color
import io.github.xlnk.telegramcopy.domain.entity.model.ImColor
import io.github.xlnk.telegramcopy.presentation.common.model.IconPlaceholderUi

class IconPlaceholderMapper {

    fun toPresentation(color: ImColor, letters: String): IconPlaceholderUi {
        return IconPlaceholderUi(Color(color.value), Color(color.value), letters)
    }
}