package com.arindam.certification.training.kotlin

import com.arindam.certification.training.kotlin.Resource.getFile
import java.io.FileReader

/**
 * We deal with resources such as files, network, database connections, streams, etc.,
 * all the time and you know the drill...
 *
 * Step 1: Acquire
 * Step 2: Use
 * Step 3: Dispose
 *
 * Let's see how the `.use` extension function makes life easier
 *
 * Created by Arindam Karmakar on 2019-07-22.
 */

object Resource {
    fun getFile(fileName: String): String {
        return javaClass.classLoader?.getResource(fileName)?.file ?: String()
    }
}

fun main() {
    val text = try {
        // (1/1) `.use` automatically manages resources that implements the `Closable` interface.
        FileReader(getFile("top-secret.txt")).use { it.readText() }
    } catch (e: Exception) {
        null
    }

    println(text)
    //println(busyButNotEffective())
}

/**
 * Resource management without the `.use` extension function! Please don't do this.
 */
private fun busyButNotEffective(): String? {
    var reader: FileReader? = null
    return try {
        reader = FileReader(getFile("top-secret.txt"))
        reader.readText()
    } catch (e: Exception) {
        null
    } finally {
        try {
            reader?.close()
        } catch (e: Exception) {
            /* swallow! 👀 */
        }
    }
}
