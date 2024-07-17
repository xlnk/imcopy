package io.github.xlnk.telegramcopy.presentation.common.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

object DateUtils {

    private val DATE_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
    private val TIME_FORMATTER = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
    private val WEEK_FORMATTER = DateTimeFormatter.ofPattern("EEE")


    fun humanizeDate(
        dateTime: LocalDateTime,
        now: LocalDateTime = LocalDateTime.now(),
    ): String {
        return when {
            now.minusDays(1).isBefore(dateTime) -> {
//                TIME_FORMATTER.format(dateTime)
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(dateTime)
            }
            now.minusWeeks(1).isBefore(dateTime) -> {
//                WEEK_FORMATTER.format(dateTime)
                DateTimeFormatter.ofPattern("EEE").format(dateTime)
            }
            else -> {
//                DATE_FORMATTER.format(dateTime)
                DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(dateTime)
            }
        }
    }
}