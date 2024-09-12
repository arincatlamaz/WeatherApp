package com.arincatlamaz.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone

object TimeUtils {

    fun unixToLocalTime(unixTime: Long, timezoneOffset: Int): String {

        val unixMilliseconds = unixTime * 1000L

        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
        calendar.timeInMillis = unixMilliseconds

        calendar.add(Calendar.SECOND, timezoneOffset)

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC") // Zaman dilimi UTC olarak ayarlanır
        return simpleDateFormat.format(calendar.time)
    }


}