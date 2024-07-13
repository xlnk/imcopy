package io.github.xlnk.telegramcopy.presentation.common.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

object DateUtils {

    private val DATE_FORMATTER = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
    private val TIME_FORMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)

    fun humanizeDate(dateTime: LocalDateTime, now: LocalDateTime = LocalDateTime.now()): String {
        val startDay = now.toLocalDate().atStartOfDay()
        return if (startDay.isBefore(dateTime)) {
            DATE_FORMATTER.format(dateTime)
        } else {
            TIME_FORMATTER.format(dateTime)
        }
    }
}