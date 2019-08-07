package com.arindam.android.training.kotlin

/**
 * Prefer delegation over inheritance for code reuse.
 * Kotlin makes it easier and has first-class support for delegation! 💪
 *
 * Created by Arindam Karmakar on 7/8/19.
 */

interface Publisher {
    fun publish(message: String)
}

class FacebookPublisher : Publisher {
    override fun publish(message: String) = println("Posting to wall...\n$message")
}

class TwitterPublisher : Publisher {
    override fun publish(message: String) = println("Twitting...\n$message")
}

class SocialMediaManager(private val publisher: Publisher) : Publisher by publisher

fun main() {
    SocialMediaManager(FacebookPublisher()).publish("Hello")
    // > Posting to wall...
    //   Hello World!

    SocialMediaManager(TwitterPublisher()).publish("World")
    // > Twitting...
    //   Hello World!
}
