package com.arindam.android.training.kotlin

/**
 * Where there is `?` 🕵️‍♂️, there is (possibly) a `null`.
 *
 * Created by Arindam Karmakar on 14/8/19.
 */

sealed class Animal(open val name: String)

data class Cat(override val name: String) : Animal(name) // 😸
data class Dog(override val name: String) : Animal(name) // 🐶

fun main() {
    // (1/5) '?' used to specify a nullable type during type declaration.
    val animal: Animal? = Cat("Tom")
    println("1: $animal") // > Cat(name=Tom)

    // (2/5) '?' used in the Elvis operator, analogous to `if (animal != null) animal else Dog("Spike")`.
    println("2: ${animal ?: Dog("Spike")}") // > Cat(name=Tom)

    // (3/5) '?' used in the null-safe access operator.
    println("3: ${animal?.name}") // > Tom

    // (4/5) '?' used to return if the LHS operand is `null`.
    println("4: ${animal ?: return}")

    // (5/5) '?' used to cast a type safely.
    println("5: ${animal as? Dog}") // > `null`

    println("6: ${animal!!}") // > Cat(name=Tom) <or> BANG! 🔫 BANG! 🔫 - The sound of shooting myself in the foot.
}
