package com.arindam.kotlin.x

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/**
 * KotlinX Serialization can serialize and deserialize your classes to and from
 * JSON, CBOR, and, Protocol Buffers for easy transportation 🚎.
 *
 * Created by Arindam Karmakar on 2019-07-23.
 */

@Serializable // (1/4) Annotate your data class with Kotlin's `Serializable` annotation
data class Book(val title: String, val author: String, val pages: Int)

fun main() {
    // (2/4) A multi-line JSON string representing a `Book`
    val bookJson = """
        {
            "title": "xUnit Test Patterns",
            "author": "Gerard Meszaros",
            "pages": 944
        }
    """.trimIndent()

    // (3/4) Deserialize JSON string to Kotlin's data class
    val book = Json.parse(Book.serializer(), bookJson)
    println(book) // > Book(title=xUnit Test Patterns, author=Gerard Meszaros, pages=944)

    // (4/4) Serialize the data class to JSON string
    val stringifiedBook = Json.stringify(Book.serializer(), book)
    println(stringifiedBook) // > {"title":"xUnit Test Patterns","author":"Gerard Meszaros","pages":944}
}
