package com.arindam.android.training.kotlin

/**
 * Created by Arindam Karmakar on 14/8/19.
 */

sealed class Base {
    abstract class A : Base()

    class A1 : A()
    class A2 : A()

    abstract class B : Base()

    class B1 : B()
    class B2 : B()
}

fun f(b: Base): Int {
    return when (b) {
        is Base.A1 -> 1
        is Base.A2 -> 2
        is Base.B1 -> 3
        is Base.B2 -> 4
        else -> 0
    }
}

object SealedClass : Base()

fun main() {
    println(f(SealedClass)) // > 0
    println(f(Base.B1())) // > 3
}
