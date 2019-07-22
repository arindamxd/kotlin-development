package com.arindam.certification.training.kotlin

/**
 * Just like null-safety, immutability is also a compile-time feature.
 * You can mutate the fields if you want to (just because you can, doesn't mean you should) 😉
 *
 * Created by Arindam Karmakar on 22/7/19.
 */

data class Employee(
        val firstName: String, // 1. (1/3) Immutable `String` property.
        val lastName: String
)

fun main() {
    val employee = Employee("Arindam", "Karmakar") // (2/3) `firstName` is "Arindam"

    Employee::class.java.getDeclaredField("firstName").apply {
        isAccessible = true
        set(employee, "John") // (3/3) Set `firstName` to "John" using reflection.
    }

    println(employee.firstName) // 3. John
}
