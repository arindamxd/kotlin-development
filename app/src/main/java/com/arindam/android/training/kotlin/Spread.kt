package com.arindam.android.training.kotlin

/**
 * Got a function that accepts variable number of arguments (vararg) and an array?
 * Use the spread (operator) - it goes hand-in-hand like 🍷 and 🧀.
 *
 * Created by Arindam Karmakar on 14/8/19.
 */

fun addAll(vararg numbers: Int): Int {
    return numbers.sum()
}

fun main() {
    println(addAll(1, 3, 5, 7, 9)) // > 25

    val numbers = intArrayOf(1, 3, 5, 7, 9)
    println(addAll(*numbers)) // > 25
}
