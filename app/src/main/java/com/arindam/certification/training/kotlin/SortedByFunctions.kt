package com.arindam.certification.training.kotlin

/**
 * The `sortedBy` functions come in handy and allow sorting of objects based on their properties
 * (as long as the property implements the `Comparable` interface) 🐁 🐈 🐕 🦒 🦕.
 *
 * Created by Arindam Karmakar on 2019-07-24.
 */

data class Employee(val name: String, val yearsOfExperience: Int)

fun main() {
    val employees = listOf(
            Employee("Dough", 6),
            Employee("Bruce", 3),
            Employee("Abby", 5)
    )

    val sortedByName = employees.sortedBy { it.name } // (1/2) Sort by name (ascending).
    println(sortedByName)
    // > [
    //      Employee(name=Abby, yearsOfExperience=5),
    //      Employee(name=Bruce, yearsOfExperience=3),
    //      Employee(name=Doug, yearsOfExperience=6)
    //   ]

    val sortedByExperience = employees.sortedByDescending { it.yearsOfExperience } // (2/2) Sort by experience (descending).
    println(sortedByExperience)
    // > [
    //      Employee(name=Doug, yearsOfExperience=6),
    //      Employee(name=Abby, yearsOfExperience=5),
    //      Employee(name=Bruce, yearsOfExperience=3)
    //   ]
}
