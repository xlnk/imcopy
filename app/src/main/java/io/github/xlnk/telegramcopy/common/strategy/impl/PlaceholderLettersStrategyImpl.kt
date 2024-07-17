package io.github.xlnk.telegramcopy.common.strategy.impl

import io.github.xlnk.telegramcopy.common.strategy.PlaceholderLettersStrategy
import javax.inject.Inject

class PlaceholderLettersStrategyImpl @Inject constructor() : PlaceholderLettersStrategy {

    override fun extractLetters(name: String): String {
        val words = name.split(' ').filter(String::isNotBlank).map { it.trim() }
        return when (words.size) {
            0 -> ""
            1 -> words.first().first().toString()
            else -> {
                "${words.first().first()}${words.last().first()}"
            }
        }
    }
}