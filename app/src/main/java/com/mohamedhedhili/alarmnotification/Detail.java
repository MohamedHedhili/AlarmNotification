package com.mohamedhedhili.alarmnotification;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView1 = (TextView) findViewById(R.id.textView1);

        Intent intent = getIntent();
        if (intent.hasExtra("Detail")) {
            textView1.setText(intent.getExtras().getString("Detail"));
        }

        NotificationManager mm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mm.cancel(1);

    }
}



