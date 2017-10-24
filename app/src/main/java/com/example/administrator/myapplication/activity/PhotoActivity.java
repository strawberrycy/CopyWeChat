package com.example.administrator.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.utils.PhotoUtils;

import java.util.List;

public class PhotoActivity extends AppCompatActivity {

    private RecyclerView selecting_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        selecting_photo = (RecyclerView) findViewById(R.id.selecting_photo);
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        List currentPhoto = PhotoUtils.getCurrent();
    }
}
