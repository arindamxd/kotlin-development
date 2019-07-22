package com.arindam.certification.training.kotlin

/**
 * Null-safety is provided by the Kotlin compiler.
 * You can still set non-nullable fields to null if you want to.
 *
 * Created by Arindam Karmakar on 2019-07-22.
 */

data class Person(
        val firstName: String, // (1/3) Non-nullable `String` property.
        val lastName: String
)

fun main() {
    val person = Person("Arindam", "Karmakar")

    // (2/3) Set `firstName` to `null` using reflection.
    Person::class.java.getDeclaredField("firstName").apply {
        isAccessible = true
        set(person, null)
    }

    println(person.firstName) // (3/3) null
}
