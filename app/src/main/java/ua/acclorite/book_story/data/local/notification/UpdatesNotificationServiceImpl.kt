package ua.acclorite.book_story.data.local.notification

import android.app.Application
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.net.Uri
import ua.acclorite.book_story.R
import ua.acclorite.book_story.data.remote.dto.LatestReleaseInfo
import javax.inject.Inject

class UpdatesNotificationServiceImpl @Inject constructor(
    private val application: Application
) : UpdatesNotificationService {

    private val notificationManager = application.getSystemService(Context.NOTIFICATION_SERVICE)
            as NotificationManager

    override fun postNotification(releaseInfo: LatestReleaseInfo) {
        val downloadLatestVersionIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(application.getString(R.string.download_latest_release_page))
        )
        val latestReleaseIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(application.getString(R.string.releases_page))
        )

        val downloadLatestVersionPendingIntent = PendingIntent.getActivity(
            application,
            1,
            downloadLatestVersionIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val latestReleasePendingIntent = PendingIntent.getActivity(
            application,
            1,
            latestReleaseIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val notification = Notification.Builder(
            application,
            UpdatesNotificationService.CHANNEL_ID
        )
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle(application.getString(R.string.updates_notification_title))
            .setContentText(
                application.getString(
                    R.string.updates_notification_desc,
                    releaseInfo.name
                )
            )
            .setContentIntent(latestReleasePendingIntent)
            .addAction(
                Notification.Action.Builder(
                    Icon.createWithResource(application, R.drawable.notification_icon),
                    application.getString(R.string.updates_notification_action),
                    downloadLatestVersionPendingIntent
                ).build()
            )
            .build()

        notificationManager.notify(
            0,
            notification
        )
    }
}