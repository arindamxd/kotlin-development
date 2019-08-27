package com.arindam.kotlin.x.interop

/**
 * Created by Arindam Karmakar on 9/8/19.
 */

data class Developer(val fullName: String, val carriesLaptop: Boolean) {

    @Throws(AllWorkNoPlayException::class)
    fun goToVacation() {
        if (carriesLaptop) {
            throw AllWorkNoPlayException()
        }
        println("Chill...")
    }
}

class AllWorkNoPlayException : Exception()
