package io.github.xlnk.telegramcopy.common.strategy

interface PlaceholderLettersStrategy {

    fun extractLetters(name: String): String
}