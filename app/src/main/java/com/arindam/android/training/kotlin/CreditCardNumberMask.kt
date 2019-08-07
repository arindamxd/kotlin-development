package com.arindam.android.training.kotlin

/**
 * Today is the day we mask credit card numbers from prying eyes 👀.
 *
 * (P.S.) Works on most card types 😜
 *
 * Created by Arindam Karmakar on 22/7/19.
 */

private const val DIGITS_TO_REVEAL = 3
private const val GROUP_SIZE = 4

fun main() {
    val maskedCreditCardNumber = maskCreditCardNumber("5012844105260576")
    println(maskedCreditCardNumber) // > **** **** **** *576
}

fun maskCreditCardNumber(creditCardNumber: String): String {
    return creditCardNumber
            .ifEmpty { throw IllegalArgumentException("'creditCardNumber' cannot be empty.") }
            .mapIndexed { index, digit -> maybeMask(index, digit, creditCardNumber.length) }
            .joinToString("")
            .chunked(GROUP_SIZE)
            .reduce { accumulator, chunk -> "$accumulator $chunk" }
}

fun maybeMask(index: Int, digit: Char, creditCardNumberLength: Int): Char {
    val shouldMask = index < (creditCardNumberLength - DIGITS_TO_REVEAL)
    return if (shouldMask) '*' else digit
}
