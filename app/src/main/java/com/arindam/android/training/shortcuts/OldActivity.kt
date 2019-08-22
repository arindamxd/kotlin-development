package com.arindam.android.training.shortcuts

import android.annotation.SuppressLint
import android.app.*
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
import androidx.core.app.NotificationManagerCompat
import com.arindam.android.training.R
import com.arindam.android.training.bubble.BubbleActivity
import kotlinx.android.synthetic.main.activity_old.*

/**
 * Created by Arindam Karmakar on 7/8/19.
 */

class OldActivity : AppCompatActivity() {

    private val tag by lazy { OldActivity::class.java.simpleName }
    private val channelId by lazy { tag }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_old)

        dynamic.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                createDynamicShortcut(this@OldActivity)
            } else {
                Log.e(tag, "Build SDK must greater or equal Nougat (N_MR1)")
            }
        }

        pinned.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createPinnedShortcut(this@OldActivity)
            } else {
                Log.e(tag, "Build SDK must greater or equal Oreo (O)")
            }
        }

        bubble.setOnClickListener {
            /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                createBubble()
            } else {
                Log.e(tag, "Build SDK must greater or equal Q")
            }*/
            createBubble()
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

    @SuppressLint("NewApi")
    private fun createBubble() {
        createNotificationChannel()

        // Create bubble intent
        val target = Intent(this, BubbleActivity::class.java)
        val bubbleIntent = PendingIntent.getActivity(this, 0, target, 0 /* flags */)

        // Create bubble metadata
        val bubbleData = Notification.BubbleMetadata.Builder()
                .setDesiredHeight(600)
                .setIcon(Icon.createWithResource(this, R.drawable.bubble_icon))
                .setIntent(bubbleIntent)
                .setAutoExpandBubble(true)
                //.setSuppressNotification(true) // Note: Although you can set these flags in Android Q Beta 2, they do not yet have any effect.
                //.setAutoExpandBubble(true) // Note: Although you can set these flags in Android Q Beta 2, they do not yet have any effect.
                .build()

        val chatBot = Person.Builder()
                .setBot(true)
                .setName("BubbleClock")
                .setImportant(true)
                .build()

        val builder = Notification.Builder(this, channelId)
                .setContentTitle("Your clock is here")
                .setContentText("Click to see clock")
                .setContentIntent(bubbleIntent)
                .setSmallIcon(R.drawable.bubble_icon)
                .setBubbleMetadata(bubbleData)
                .setAutoCancel(true)
                .addPerson(chatBot)

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(5000, builder.build())
    }

    @SuppressLint("NewApi")
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setAllowBubbles(true)

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }
}
