package com.arindam.kotlin.x

/**
 * To prevent introducing bugs 🐞 inadvertently while using destructuring declarations,
 *
 * 1. Match destructured variable names to property names.
 * 2. Promote IDE's warning to error.
 * 3. Write tests 😉
 *
 * Created by Arindam Karmakar on 9/8/19.
 */

// (1/4) The commented code is an OLD version of our `HomoSapien` data class.
/*data class HomoSapien(
        val firstName: String,
        val lastName: String = ""
)*/

data class HomoSapien(
        val firstName: String,
        val middleName: String = "", // (2/4) Newly introduced `middleName` property in CURRENT version.
        val lastName: String = ""
)

fun main() {
    // (3/4) Destructured variable names aren't the same as the property names from the data class.
    val (firstName, middleName, lastName) = HomoSapien("John", "Classic", "Doe")
    // OR
    // val (firstName, _, lastName) = HomoSapien("John", "Classic", "Doe")
    // OR
    // val (first, _, last) = HomoSapien("John", "Classic", "Doe")

    println("$lastName, $firstName") // > Classic, John // (4/4) BUG!! 🐞 ❌
                                     //   Expected: Doe, John ✅
}
