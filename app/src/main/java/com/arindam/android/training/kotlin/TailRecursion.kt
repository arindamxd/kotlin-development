package com.arindam.android.training.kotlin

/**
 * Can think recursively, but worried that you'll run out of stack space?
 * Tail recursive calls are here for the rescue! 🐅 🦒 🐒
 *
 * Created by Arindam Karmakar on 2019-07-22.
 */

typealias Index = Int

fun binarySearch(numbers: Array<Int>, key: Int): Index? {
    // (1/3) A local (capturing) tail recursive function.
    tailrec fun go(low: Index, high: Index): Index? {
        if (high < low) return null
        val mid = low + (high - low) / 2

        return when {
            numbers[mid] == key -> mid
            numbers[mid] > key -> go(low, high - 1)
            else -> go(low + 1, high) // (2/3) Tail call.
        }
    }

    return go(0, numbers.lastIndex) // (3/3) Recursive search kick-off.
}

fun main() {
    val numbers = arrayOf(1, 3, 5, 7, 9, 11)
    println(binarySearch(numbers, 7)) // > 3
}
