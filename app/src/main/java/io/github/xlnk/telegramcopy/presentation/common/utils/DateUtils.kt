package io.github.xlnk.telegramcopy.presentation.common.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

object DateUtils {

    private var DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
    private var TIME_FORMATTER = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
    private var WEEK_FORMATTER = DateTimeFormatter.ofPattern("EEE")

    private fun init() {

    }

    fun humanizeDate(
        dateTime: LocalDateTime,
        now: LocalDateTime = LocalDateTime.now(),
    ): String {
        return when {
            now.minusDays(1).isBefore(dateTime) -> {
                TIME_FORMATTER.format(dateTime)
            }
            now.minusWeeks(1).isBefore(dateTime) -> WEEK_FORMATTER.format(dateTime)
            else -> DATE_FORMATTER.format(dateTime)
        }
    }
}