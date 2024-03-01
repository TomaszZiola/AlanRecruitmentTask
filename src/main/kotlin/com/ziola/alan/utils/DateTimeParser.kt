package com.ziola.alan.utils

import java.time.LocalDateTime.parse
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
import java.time.format.DateTimeFormatterBuilder

object DateTimeParser {
    fun toZonedDateTime(date: String): ZonedDateTime {
        val formatter =
            DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(ISO_LOCAL_DATE_TIME)
                .optionalStart()
                .appendOffsetId()
                .toFormatter()
        return ZonedDateTime.parse(date, formatter)
    }
}
