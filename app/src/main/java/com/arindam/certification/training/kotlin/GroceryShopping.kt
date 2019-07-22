package com.arindam.certification.training.kotlin

/**
 * What do you get when grocery shopping?
 *
 * Option 1: Milk, Eggs, Bread
 * Option 2: Milk 🥛, Eggs 🥚, and Bread 🍞
 *
 * Created by Arindam Karmakar on 22/7/19.
 */

fun main() {
    val things = listOf("Milk", "Eggs", "Bread")
    val emojis = listOf("\uD83E\uDD5B", "\uD83E\uDD5A", "\uD83C\uDF5E")

    val humanizedThingsToBuy = things
            // (1/3) Combine elements by index from `things` and `emojis`.
            .zip(emojis) { thing, emoji -> "$thing $emoji" }
            // (2/3) Mapping by index to introduce a conjunction before the last "thing-emoji" combination.
            .mapIndexed { index, visualThing ->
                val last = index == things.lastIndex
                if (last) "and $visualThing" else visualThing
            }
            // (3/3) `.joinToString()` uses a `StringBuilder` underneath - efficiency.
            .joinToString()

    println(humanizedThingsToBuy) // > Milk 🥛, Eggs 🥚, and Bread 🍞
}