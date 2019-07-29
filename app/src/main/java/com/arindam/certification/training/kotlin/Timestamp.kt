package com.arindam.certification.training.kotlin

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Arindam Karmakar on 26/7/19.
 */

/**
 * Get Current Time In Millis
 */
internal fun getCurrentTimeStamp(): Long = Calendar.getInstance().timeInMillis

/**
 * Get Current Time In Formatted String
 */
internal fun getCurrentTimeStampSimpleFormat(): String = utcFromDate(Calendar.getInstance())

/**
 * Get Time of 90 days back In Formatted String
 */
internal fun utcFallbackDate(): String = utcDaysBackDate(Calendar.getInstance(), 90)
internal fun isoFallbackDate(): String = isoDaysBackDate(Calendar.getInstance(), 90)


/* UTC Format Date */

/**
 * Transform Timestamp to UTC String.
 */
fun utcFromDate(time: Long): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val utcDate = dateFormat.format(Date(time))
    return utcDate.substring(0, 22) + ":" + utcDate.substring(22)
}

/**
 * Transform Date to UTC String.
 */
fun utcFromDate(date: Date): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val utcDate = dateFormat.format(date)
    return utcDate.substring(0, 22) + ":" + utcDate.substring(22)
}

/**
 * Transform Calender to UTC String.
 */
fun utcFromDate(calendar: Calendar): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val utcDate = dateFormat.format(calendar.time)
    return utcDate.substring(0, 22) + ":" + utcDate.substring(22)
}

/**
 * Parse Formatted UTC String to Time Stamp.
 */
fun parseUTC(utcFormattedDate: String, fallbackDate: String = utcFallbackDate()): Long {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val parsedDate = try {
        dateFormat.parse(utcFormattedDate)
    } catch (ex: Exception) {
        dateFormat.parse(fallbackDate)
    }
    return parsedDate.time
}

/**
 * Get Number of Days Back Date UTC String.
 */
internal fun utcDaysBackDate(calendar: Calendar, days: Int): String {
    calendar.add(Calendar.DATE, -days)
    val date = calendar.time
    return utcFromDate(date)
}


/* ISO Format Date */

/**
 * Transform Timestamp to ISO 8601 String.
 */
fun isoFromDate(time: Long): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
    val utcDate = dateFormat.format(Date(time))
    return utcDate.substring(0, 22) + ":" + utcDate.substring(22)
}

/**
 * Transform Date to ISO 8601 String.
 */
fun isoFromDate(date: Date): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
    val utcDate = dateFormat.format(date)
    return utcDate.substring(0, 22) + ":" + utcDate.substring(22)
}

/**
 * Transform Calender to ISO 8601 String.
 */
fun isoFromDate(calendar: Calendar): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH)
    val utcDate = dateFormat.format(calendar.time)
    return utcDate.substring(0, 22) + ":" + utcDate.substring(22)
}

/**
 * Parse Formatted ISO 8601 String to Timestamp.
 */
fun parseISO(isoFormattedDate: String, fallbackDate: String = isoFallbackDate()): Long {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
    val parsedDate = try {
        dateFormat.parse(isoFormattedDate)
    } catch (ex: Exception) {
        dateFormat.parse(fallbackDate)
    }
    return parsedDate.time
}

/**
 * Get Number of Days Back Date ISO 8601 String.
 */
internal fun isoDaysBackDate(calendar: Calendar, days: Int): String {
    calendar.add(Calendar.DATE, -days)
    val date = calendar.time
    return utcFromDate(date)
}

fun main() {
    val time1 = parseUTC("2019-07-26T09:06:24+00:00") // > 1564131984000
    val time2 = utcFromDate(time1) // > 2019-07-26T09:06:24+00:00

    val time3 = getCurrentTimeStamp()
    val time4 = getCurrentTimeStampSimpleFormat()

    println(time1)
    println(time2)

    println(time3)
    println(time4)
}