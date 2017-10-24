package com.example.administrator.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.myapplication.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
    }

    public void OnClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button1:
                intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                break;
              case R.id.button2:
                intent = new Intent(SplashActivity.this, GirdViewActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(SplashActivity.this,NotificationActivity.class);
                startActivity(intent);
                break;

                default:
                    break;

        }

    }
}
