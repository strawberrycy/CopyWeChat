package com.example.administrator.myapplication.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.administrator.myapplication.R;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //发送正常的通知
                Notification.Builder builder = new Notification.Builder(this);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 100, intent, 0);
                builder.setContentIntent(pendingIntent);
                builder.setContentText("这是一个正常的通知");
                builder.setSmallIcon(R.drawable.pic1);
                builder.setAutoCancel(true);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.pic2));
                Notification notification = builder.build();
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(1, notification);
                break;
            case R.id.button2:
                //发送悬挂式的通知
                break;
            case R.id.button3:
                //发送折叠式的通知
                break;
            default:
                break;

        }

    }
}
