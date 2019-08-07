package com.arindam.android.training.daynight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arindam.android.training.R
import kotlinx.android.synthetic.main.activity_daynight.*

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class DayNightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daynight)


        // Set Dark Mode
        dark_mode.setOnClickListener {
            ThemeHelper.applyTheme(ThemeHelper.darkMode)
        }

        // Set Light Mode
        light_mode.setOnClickListener {
            ThemeHelper.applyTheme(ThemeHelper.lightMode)
        }
    }
}
