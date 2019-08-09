package com.arindam.android.training.kotlin.jvmstatic

import kotlin.jvm.JvmStatic

/**
 * Created by Arindam Karmakar on 9/8/19.
 */

class Avenger {
    companion object {
        val nonStaticProperty: String = "I'm not static!"

        @JvmStatic
        val staticProperty: String = "I'm static!"
    }
}