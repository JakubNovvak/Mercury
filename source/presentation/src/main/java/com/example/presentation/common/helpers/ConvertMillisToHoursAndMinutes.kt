package com.example.presentation.common.helpers

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun convertMillisToHoursAndMinutes(milliseconds: Long): String {
    val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    return Instant.ofEpochMilli(milliseconds)
        .atZone(ZoneId.systemDefault())
        .format(timeFormat)
}