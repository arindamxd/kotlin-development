package com.arindam.android.training.kotlin

/**
 * Sometimes it pays off to be lazy 😴.
 * See how Kotlin sequences can optimize operations on large data sets.
 *
 * Created by Arindam Karmakar on 2019-07-24.
 */

fun main() {
    (1..7) // (1/2) Iterables are evaluated eagerly and in their entirety at each processing step.
            .filter { println("Filtering $it..."); it % 2 == 0 }
            .take(1)
            .forEach { println(it) }
    // > Filtering 1...
    //   Filtering 3...
    //   Filtering 4...
    //   Filtering 5...
    //   Filtering 6...
    //   Filtering 7...
    //   2


    (1..7) // (2/2) Sequences are evaluated lazily and can yield performance benefits on LARGE data sets.
            .asSequence()
            .filter { println("Filtering $it..."); it % 2 == 0 }
            .take(1)
            .forEach { println(it) }
    // > Filtering 1...                         //    Filtering 3...
    //   Filtering 2...
    //   2
}
