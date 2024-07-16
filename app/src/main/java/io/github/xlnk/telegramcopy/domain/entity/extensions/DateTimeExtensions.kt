package io.github.xlnk.telegramcopy.domain.entity.extensions

import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneOffset
import java.time.ZonedDateTime
import kotlin.reflect.KClass

val LocalDateTimeZero: LocalDateTime = LocalDateTime.of(0, Month.JANUARY, 1, 0, 0)

val LocalDateTime.ZERO: LocalDateTime get() = LocalDateTimeZero

val KClass<LocalDateTime>.ZERO: LocalDateTime get() = LocalDateTimeZero

val ZonedDateTimeMax: ZonedDateTime = ZonedDateTime.of(LocalDateTime.MAX, ZoneOffset.UTC)

val ZonedDateTime.MAX: ZonedDateTime get() = ZonedDateTimeMax

val KClass<ZonedDateTime>.MAX: ZonedDateTime get() = ZonedDateTimeMax