package com.example.oeloem.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int notificationID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        displayNotification();

    }

    protected void displayNotification()

    {

        Intent i = new Intent(this, NotificationViewActivity.class);
        i.putExtra("notificationID", notificationID);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder notifBuilder;
        notifBuilder = new NotificationCompat.Builder(this)

                .setSmallIcon(R.drawable.nt)
                .setContentTitle("Ada Meeting BEM Sekarang...!")
                .setContentText("Reminder: Rapat Akan Mulai 5 minutes")
                .setContentIntent(pendingIntent)
                .addAction(R.mipmap.ic_launcher,"Read More",pendingIntent);

        Vibrator vi;

        vi=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (vi.hasVibrator()){

            vi.vibrate(20000);

        }

        nm.notify(notificationID, notifBuilder.build());

    }

}






