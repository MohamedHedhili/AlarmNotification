package com.mohamedhedhili.alarmnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Share extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Intent intent = getIntent();

        if (intent.hasExtra("Share")) {

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, intent.getExtras().getString("Share"));
            if (share.resolveActivity(getPackageManager()) != null) {
                startActivity(Intent.createChooser(share, "Share"));
            }
        }

        NotificationManager mm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mm.cancel(1);

        finish();

    }
}