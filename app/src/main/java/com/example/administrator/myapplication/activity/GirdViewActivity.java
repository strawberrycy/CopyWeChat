package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.example.administrator.myapplication.R;

public class GirdViewActivity extends AppCompatActivity {


    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gird_view);
        initView();
    }

    /**
     * 初始化数据
     */
    private void initView() {
        mCardView = (CardView) findViewById(R.id.cardview);
        mCardView.setCardElevation(10);
    }
}
