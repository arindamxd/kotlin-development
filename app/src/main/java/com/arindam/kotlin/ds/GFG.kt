package com.arindam.kotlin.ds

/**
 * Kotlin program to find out all combinations of positive numbers that add up to given number.
 *
 * Created by Arindam Karmakar on 29/7/19.
 */

fun main() {
    val k = 5
    findCombinations(k)
}

/**
 * @param arr        array to store the combination
 * @param index      next location in array
 * @param num        given number
 * @param reducedNum reduced number
 */
fun findCombinationsUtil(arr: IntArray, index: Int, num: Int, reducedNum: Int) {

    // Base condition
    if (reducedNum < 0)
        return

    // If combination is
    // found, print it
    if (reducedNum == 0) {
        for (i in 0 until index)
            print(arr[i].toString() + " ")

        println()
        return
    }

    // Find the previous number
    // stored in arr[]. It helps
    // in maintaining increasing
    // order
    val prev = if (index == 0) 1 else arr[index - 1]

    // note loop starts from
    // previous number i.e. at
    // array location index - 1
    for (k in prev..num) {
        // next element of
        // array is k
        arr[index] = k

        // call recursively with
        // reduced number
        findCombinationsUtil(arr, index + 1, num, reducedNum - k)
    }
}

/**
 * Function to find out all combinations of positive numbers that add up to given number.
 * It uses findCombinationsUtil()
 *
 * @param n max n elements
 */
fun findCombinations(n: Int) {
    // array to store the combinations
    // It can contain max n elements
    val arr = IntArray(n)

    // find all combinations
    findCombinationsUtil(arr, 0, n, n)
}
