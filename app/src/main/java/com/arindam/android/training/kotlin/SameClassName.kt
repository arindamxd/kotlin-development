package com.arindam.android.training.kotlin

/**
 * Have two classes with the same name causing a clash? 🤼‍♂️
 * Use the `as` keyword to make peace ☮️.
 *
 * Created by Arindam Karmakar on 2019-07-22.
 */

// (1/2) Having two `Cake` classes will cause a clash.
import com.arindam.android.training.kotlin.class_one.Cake

// (2/3) Use the `as` keyword to rename locally!
import com.arindam.android.training.kotlin.class_two.Cake as SmoorCake

fun main() {
    val cake = Cake()
    val smoorCake = SmoorCake()

    println(cake::class.java.name) // > com.arindam.certification.training.kotlin.class_one.Cake
    println(smoorCake::class.java.name) // > com.arindam.certification.training.kotlin.class_two.Cake
}