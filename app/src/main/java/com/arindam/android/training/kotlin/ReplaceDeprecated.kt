package com.arindam.android.training.kotlin

/**
 * Now that we have deprecated a function,
 * we just have to replace it in 327 call sites 😨. Not anymore 😅
 *
 * Created by Arindam Karmakar on 22/7/19.
 */

fun increment(number: Int): Int = number + 1 // (1/5) Replacement for deprecated function.

@Deprecated(
        message = "Boring name.", // (2/5) A deprecation message, to keep users informed.
        replaceWith = ReplaceWith(
                /*
                 * (3/5) Expression helps the IDE replace deprecated functions with a replacement
                 *       in call sites. Please pay attention to (old) parameter names and order
                 *       of those parameters in the replacement expression.
                 */
                "increment(count)",
                "com.arindam.certification.training.kotlin.increment"
        ),
        level = DeprecationLevel.WARNING // (4/5) Can be WARNING, ERROR or HIDDEN
)
fun addOne(count: Int): Int = count + 1

fun main() {
    println(addOne(0)) // (5/5) Use the IDE's quick-fix feature to replace deprecated function calls.
}