package com.example.ttuguide.Activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.widget.Toast;


public class AlarmReceiver extends BroadcastReceiver {

    public static final String CHANNEL_ID = "AlarmChannel";
    public static final int NOTIFICATION_ID = 1;

    private static final int STOP_ALARM_REQUEST_CODE = 1;
    private static Ringtone ringtone = null;
    private static Vibrator vibrator = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("STOP_ALARM".equals(intent.getAction())) {
            if (ringtone != null && ringtone.isPlaying()) {
                ringtone.stop();
            }
            if (vibrator != null) {
                vibrator.cancel();
            }
            return;
        }

        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);

        Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();

        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

        Intent stopIntent = new Intent(context, StopAlarmReceiver.class);
        PendingIntent stopPendingIntent = PendingIntent.getBroadcast(context, STOP_ALARM_REQUEST_CODE, stopIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Alarm Notifications",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
        String courseName = intent.getStringExtra("course_name");

//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
//                .setSmallIcon(R.drawable.baseline_alarm_24) // Replace with your icon
//                .setContentTitle("Alarm")
//                .setContentText("Tap to stop the alarm " + courseName)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .addAction(new NotificationCompat.Action(R.drawable.baseline_stop_24, "Stop Alarm", stopPendingIntent))
//                .setAutoCancel(true)
//                .setFullScreenIntent(stopPendingIntent, true); // Ensuring full-screen intent
//
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

//    public static void stopRingtone() {
//        if (ringtone != null && ringtone.isPlaying()) {
//            ringtone.stop();
//        }
//    }
}
