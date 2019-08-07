package com.arindam.android.training.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arindam.android.training.R

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data
    }
}
