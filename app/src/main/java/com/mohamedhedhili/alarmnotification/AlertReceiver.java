package com.mohamedhedhili.alarmnotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import java.util.Random;


/**
 * Created by mohamedHedhili on 05/11/2016.
 */
public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String[] All_meeting = context.getResources().getStringArray(R.array.All_meeting);
        Random Rnd = new Random();
        int NUM = Rnd.nextInt(All_meeting.length);
        String msg = All_meeting[NUM];

        Intent intent_Page2 = new Intent(context, Detail.class);
        intent_Page2.putExtra("Detail",msg);
        PendingIntent pendOpne = PendingIntent.getActivity(context, 222, intent_Page2, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent intent_share = new Intent(context, Share.class);
        intent_share.putExtra("Share",msg);
        PendingIntent pend_share = PendingIntent.getActivity(context, 333, intent_share, PendingIntent.FLAG_UPDATE_CURRENT);
        Intent intent_mainActivity = new Intent(context, MainActivity.class);
        PendingIntent notification = PendingIntent.getActivity(context, 100, intent_mainActivity, 0);

        Bitmap bitmap_icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.conference);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setLargeIcon(bitmap_icon)
                .setContentTitle("Reminder")
                .setContentText(msg)
                .addAction(R.drawable.ic_reply_black_24dp, "Detail", pendOpne)
                .addAction(R.drawable.ic_share_black_24dp, "Share", pend_share);;

        builder.setContentIntent(notification);
        builder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        builder.setAutoCancel(true);

        NotificationManager mm =( NotificationManager ) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mm.cancel(1);
        mm.notify(1, builder.build());

    }


}



