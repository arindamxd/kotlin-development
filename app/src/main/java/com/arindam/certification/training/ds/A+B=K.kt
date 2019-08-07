package com.arindam.certification.training.ds

/**
 * Find a and b from list (1, 2, 3, 4, 5, 6, 8, 10, 12) such that a + b = k, where k = 8.
 *
 * Sample Result: a = 3, b = 5
 * Print {3, 5}, {2, 6}
 *
 * Created by Roopan C on 29/7/19.
 */

fun main() {

    val input = arrayOf(1, 2, 3, 4, 5, 6, 8, 10, 12)
    val k = 8

    val set = HashSet<Int>()
    for (a in input) {

        val b = k - a
        if (set.contains(b)) {
            println("Sum of $k is $a and $b")
        }

        set.add(a)
    }
}
