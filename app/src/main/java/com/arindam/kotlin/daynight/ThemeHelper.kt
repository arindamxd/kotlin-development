package com.arindam.kotlin.daynight

import androidx.appcompat.app.AppCompatDelegate

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

object ThemeHelper {
    const val lightMode = "light"
    const val darkMode = "dark"
    const val batterySaverMode = "battery"
    const val default = "default"

    fun applyTheme(theme: String) {
        when (theme) {
            lightMode -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            darkMode -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            batterySaverMode -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
            default -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}
