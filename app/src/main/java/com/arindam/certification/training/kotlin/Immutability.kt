package com.arindam.certification.training.kotlin

/**
 * Just like null-safety, immutability is also a compile-time feature.
 * You can mutate the fields if you want to (just because you can, doesn't mean you should) 😉
 *
 * Created by Arindam Karmakar on 22/7/19.
 */

data class AndroidDeveloper(
        val firstName: String, // 1. (1/3) Immutable `String` property.
        val lastName: String
)

fun main() {
    val androidDeveloper = AndroidDeveloper("Arindam", "Karmakar") // (2/3) `firstName` is "Arindam"

    AndroidDeveloper::class.java.getDeclaredField("firstName").apply {
        isAccessible = true
        set(androidDeveloper, "John") // (3/3) Set `firstName` to "John" using reflection.
    }

    println(androidDeveloper.firstName) // 3. John
}
