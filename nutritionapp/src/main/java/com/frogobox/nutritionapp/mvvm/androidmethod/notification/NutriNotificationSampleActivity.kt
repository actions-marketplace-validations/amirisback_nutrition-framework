package com.frogobox.nutritionapp.mvvm.androidmethod.notification

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.RemoteViews
import com.frogobox.nutritionapp.NutriApplication
import com.frogobox.nutritionapp.R
import com.frogobox.nutritionapp.core.BaseActivity
import com.frogobox.nutritionapp.databinding.ActivityNutriNotificationSampleBinding
import com.frogobox.nutritionapp.mvvm.androidmethod.notification.custom.CustomNotifActivity
import com.frogobox.nutritionapp.mvvm.androidmethod.notification.stack.StackNotifActivity
import com.frogobox.nutritionframework.notification.NutriNotifCustomContentViewListener
import com.frogobox.nutritionframework.notification.NutriNotification


class NutriNotificationSampleActivity : BaseActivity<ActivityNutriNotificationSampleBinding>() {

    companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "CHANNEL_$NOTIFICATION_ID"
        private const val CHANNEL_NAME = "CHANNEL_NAME_$CHANNEL_ID"
    }

    override fun setupViewBinding(): ActivityNutriNotificationSampleBinding {
        return ActivityNutriNotificationSampleBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupDetailActivity("Nutri Notification")
        binding.apply {

            btnSendNotif.setOnClickListener {
                sendNotification()
            }

            btnCustomNotif.setOnClickListener {
                intentToCustom()
            }

            btnStackNotif.setOnClickListener {
                intentToStack()
            }

            btnShowExpanded.setOnClickListener {
                sendNotificationCustom()
            }

        }
    }

    private fun sendNotification() {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/amirisback"))
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        NutriNotification.Inject(this) // Intialize for Context
            .setChannelId(CHANNEL_ID) // Intialize for Channel ID
            .setChannelName(CHANNEL_NAME) // Initialize for Channel Name
            .setContentIntent(pendingIntent) // Initialize for Content Intent
            .setSmallIcon(R.drawable.ic_nutri_notification_notif) // Initialize for Small Icon
            .setLargeIcon(R.drawable.ic_nutri_notification_notif) // Initialize for Large Icon
            .setContentTitle(resources.getString(R.string.content_title)) // Initialize for Content Title
            .setContentText(resources.getString(R.string.content_text)) // Initialize for Content Text
            .setSubText(resources.getString(R.string.subtext)) // Initialize for Sub Text
            .setupAutoCancel() // Initialize for Auto Cancel
            .build() // Build the Nutri Notification
            .launch(NOTIFICATION_ID) // Notify the Nutri Notification

    }

    private fun sendNotificationCustom() {
        val clickIntent = Intent(this, NutriNotificationReceiver::class.java)
        val clickPendingIntent = PendingIntent.getBroadcast(this, 0, clickIntent, 0)

        val collapsed = object : NutriNotifCustomContentViewListener {
            override fun setupCustomView(): Int {
                return R.layout.notification_collapsed
            }

            override fun setupComponent(context: Context, customView: RemoteViews) {
                customView.apply {
                    setTextViewText(R.id.text_view_collapsed_1, "Hello World!")
                }
            }
        }

        val expanded = object : NutriNotifCustomContentViewListener {
            override fun setupCustomView(): Int {
                return R.layout.notification_expanded
            }

            override fun setupComponent(context: Context, customView: RemoteViews) {
                customView.apply {
                    setImageViewResource(R.id.image_view_expanded, R.drawable.ic_android)
                    setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent)
                }
            }
        }

        NutriNotification.Inject(this) // Intialize for Context
            .setChannelId(NutriApplication.CHANNEL_ID) // Intialize for Channel ID
            .setChannelName(NutriApplication.CHANNEL_NAME) // Initialize for Channel Name
            .setSmallIcon(R.drawable.ic_android) // Initialize for Small Icon
            .setCustomContentView(collapsed)
            .setCustomBigContentView(expanded)
            .build() // Build the Nutri Notification
            .launch(NutriApplication.NOTIFICATION_ID) // Notify the Nutri Notification

    }

    private fun intentToCustom() {
        startActivity(Intent(this, CustomNotifActivity::class.java))
    }

    private fun intentToStack() {
        startActivity(Intent(this, StackNotifActivity::class.java))
    }

}