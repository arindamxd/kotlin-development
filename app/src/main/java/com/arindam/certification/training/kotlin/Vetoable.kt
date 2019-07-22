package com.arindam.certification.training.kotlin

import kotlin.properties.Delegates.vetoable

/**
 * Use your veto power to selectively say yay 👍 or nay 👎 while updating mutable properties.
 *
 * Created by Arindam Karmakar on 2019-07-22.
 */

const val MIN_LEADERSHIP_ATTENDANCE = 98.5

data class Student(val name: String, val attendance: Double)

val monica = Student("Monica", 100.0)
val joey = Student("Joey", 10.0)
val ross = Student("Ross", 98.5)

// (1/4) Pass an initial value to the `vetoable` property delegate.
var classLeader by vetoable(monica) { _, _, newLeader ->
    newLeader.attendance >= MIN_LEADERSHIP_ATTENDANCE // (2/4) The predicate accepts or rejects new values.
}

fun main() {
    println(classLeader.name) // > Monica

    classLeader = joey // (3/4) Nope, that's not happening 😞
    println(classLeader.name) // > Monica

    classLeader = ross // (4/4) Go team Ross! 🏆 🎉
    println(classLeader.name) // > Ross
}
