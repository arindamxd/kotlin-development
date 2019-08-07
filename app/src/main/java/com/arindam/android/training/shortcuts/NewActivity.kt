package com.arindam.android.training.shortcuts

import android.content.pm.ShortcutManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.arindam.android.training.R

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class NewActivity : AppCompatActivity() {

    private val TAG by lazy { NewActivity::class.java.simpleName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            manageShortcuts()
        } else {
            Log.e(TAG, "Build SDK must greater or equal Nougat (N_MR1)")
        }
    }

    @RequiresApi(Build.VERSION_CODES.N_MR1)
    private fun manageShortcuts() {
        val shortcutManager = getSystemService(ShortcutManager::class.java)

        shortcutManager?.let {
            if (it.dynamicShortcuts.size == 0) {
                // Application restored. Need to re-publish dynamic shortcuts.
                if (it.pinnedShortcuts.size > 0) {
                    // Pinned shortcuts have been restored. Use
                    // updateShortcuts() to make sure they contain
                    // up-to-date information.
                } else {
                    // Do something
                }
            } else {
                Log.e(TAG, "${it.pinnedShortcuts}")
            }
        }
    }
}
