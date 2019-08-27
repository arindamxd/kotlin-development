package com.arindam.kotlin.x

/**
 * Today is the day we sort and group our superheroes by their alter ego 🦸‍♀️🦸‍♂️
 *
 * Created by Arindam Karmakar on 22/7/19.
 */

data class Superhero(val name: String, val realName: String)

fun main() {
    val superheros = listOf(
            Superhero("Hulk", "Bruce Banner"),
            Superhero("Captain America", "Steve Rogers"),
            Superhero("Shaktimaan", "Gangadhar Vidhyadhar Mayadhar Omkarnath Shastri"),
            Superhero("Ironman", "Tony Stark"),
            Superhero("Spiderman", "Peter Parker"),
            Superhero("Black Widow", "Natasha Romanoff"),
            Superhero("Hawkeye", "Clint Barton"),
            Superhero("Thor", "Thor"),
            Superhero("Ant-man", "Scott Lang"),
            Superhero("Captain Marvel", "Carol Danvers"),
            Superhero("Doctor Strange", "Stephen Vincent Strange")
    )

    val superherosAlterEgoDictionary = superheros
            .sortedBy { it.realName }
            .groupBy({ it.realName.first().toUpperCase() }) { it.realName }

    println(superherosAlterEgoDictionary)
    /* >
    {
        B = [Bruce Banner],
        C = [Carol Danvers, Clint Barton],
        G = [Gangadhar Vidhyadhar Mayadhar Omkarnath Shastri],
        N = [Natasha Romanoff],
        P = [Peter Parker],
        S = [Scott Lang, Stephen Vincent Strange, Steve Rogers],
        T = [Thor, Tony Stark]
    }
     */
}
