package com.arindam.android.training.kotlin

/**
 * Chop 🔪 chop 🔪 ... that's how we partition a list using a predicate 😉
 *
 * Created by Arindam Karmakar on 22/7/19.
 */

enum class Attendance { CONFIRMED, UNCONFIRMED }

data class Speaker(val name: String, val attendance: Attendance = Attendance.CONFIRMED)

fun main() {
    val speakers = listOf(
            Speaker("John"),
            Speaker("Eric"),
            Speaker("Santiago", Attendance.UNCONFIRMED)
    )

    val (confirmedSpeakers, unconfirmedSpeakers) = speakers.partition {
        it.attendance == Attendance.CONFIRMED // (1/1) Partition 🔪 using a predicate!
    }

    // > [Speaker(name=John, attendance=CONFIRMED), Speaker(name=Eric, attendance=CONFIRMED)]
    println(confirmedSpeakers)

    // > [Speaker(name=Santiago, attendance=UNCONFIRMED)]
    println(unconfirmedSpeakers)
}
