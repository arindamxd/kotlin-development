package com.arindam.kotlin.ds

/**
 * Find all possible combinations from list (a, b, c ... n).
 *
 * Sample Result: (a, b, c, ab, bc, cd, abc, acb ...)
 *
 * Created by Arindam Karmakar on 29/7/19.
 */

fun main() {

    val str = "ABC"
    val n = str.length
    val permutation = Permutation()
    permutation.permute(str, 0, n - 1)

    //TODO: Not completed
    val list = listOf("a", "b", "c")
}

class Permutation {

    /**
     * permutation function
     *
     * @param s string to calculate permutation for
     * @param l   starting index
     * @param r   end index
     */
    fun permute(s: String, l: Int, r: Int) {
        var str = s
        if (l == r)
            println(str)
        else {
            for (i in l..r) {
                str = swap(str, l, i)
                permute(str, l + 1, r)
                str = swap(str, l, i)
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    fun swap(a: String, i: Int, j: Int): String {
        val temp: Char
        val charArray = a.toCharArray()
        temp = charArray[i]
        charArray[i] = charArray[j]
        charArray[j] = temp
        return String(charArray)
    }
}
