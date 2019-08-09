package com.arindam.android.training.kotlin

/**
 * Use operator overloading 🚛 to your advantage to build fluent APIs.
 *
 * Created by Arindam Karmakar on 9/8/19.
 */

data class Money(val value: Double)

data class Wallet(val total: Money) {
    // (1/2) Use the `operator` keyword to override a set of predefined operators in Kotlin.
    operator fun contains(required: Money): Boolean = total.value >= required.value
}

fun main() {
    val wallet = Wallet(Money(100.0))
    println(wallet.contains(Money(60.0))) // > true

    // (2/2) The above function call can be rewritten using the `in` operator as follows,
    println(Money(50.0) in wallet)  // >> true  ✅
    println(Money(150.0) in wallet) // >> false ✅
}
