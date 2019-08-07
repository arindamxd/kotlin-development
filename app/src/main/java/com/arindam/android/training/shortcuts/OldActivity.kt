package com.arindam.android.training.shortcuts

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.arindam.android.training.R
import kotlinx.android.synthetic.main.activity_old.*

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class OldActivity : AppCompatActivity() {

    private val TAG by lazy { OldActivity::class.java.simpleName }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old)

        dynamic.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                createDynamicShortcut(this@OldActivity)
            } else {
                Log.e(TAG, "Build SDK must greater or equal Nougat (N_MR1)")
            }
        }

        pinned.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createPinnedShortcut(this@OldActivity)
            } else {
                Log.e(TAG, "Build SDK must greater or equal Oreo (O)")
            }
        }
    }

    /**
     * An example of creating a dynamic shortcut and associating
     * it with your app appears in the following code snippet
     */
    @RequiresApi(Build.VERSION_CODES.N_MR1)
    private fun createDynamicShortcut(context: Context) {
        val shortcutManager = getSystemService(ShortcutManager::class.java)
        shortcutManager?.let {
            val dynamicShortcutInfo = ShortcutInfo.Builder(context, "id1")
                    .setShortLabel("Dynamic")
                    .setLongLabel("My Dynamic Shortcut")
                    .setIcon(Icon.createWithResource(context, R.drawable.icon_dynamic))
                    .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://arindamxd.github.io/")))
                    .build()

            it.dynamicShortcuts = listOf(dynamicShortcutInfo)
        }
    }

    /**
     * The following code snippet demonstrates how to create a pinned shortcut
     */
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createPinnedShortcut(context: Context) {
        val shortcutManager = getSystemService(ShortcutManager::class.java)

        shortcutManager?.let {
            if (it.isRequestPinShortcutSupported) {
                // Assumes there's already a shortcut with the ID "my-shortcut".
                // The shortcut must be enabled.
                val pinnedShortcutInfo = ShortcutInfo.Builder(context, "id2")
                        .setShortLabel("Pinned")
                        .setLongLabel("My Pinned Shortcut")
                        .setIcon(Icon.createWithResource(context, R.drawable.icon_pinned))
                        .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://arindamxd.github.io/")))
                        .build()

                // Create the PendingIntent object only if your app needs to be notified
                // that the user allowed the shortcut to be pinned. Note that, if the
                // pinning operation fails, your app isn't notified. We assume here that the
                // app has implemented a method called createShortcutResultIntent() that
                // returns a broadcast intent.
                val pinnedShortcutCallbackIntent = it.createShortcutResultIntent(pinnedShortcutInfo)

                // Configure the intent so that your app's broadcast receiver gets
                // the callback successfully.For details, see PendingIntent.getBroadcast().
                val successCallback = PendingIntent.getBroadcast(
                        context, /* request code */ 0,
                        pinnedShortcutCallbackIntent, /* flags */ 0
                )

                it.requestPinShortcut(pinnedShortcutInfo, successCallback.intentSender)
            }
        }
    }
}
