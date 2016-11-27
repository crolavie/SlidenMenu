package com.jht.administrator.slidenmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn1:
                //基本使用
                intent.setClass(MainActivity.this, SlideMethodActivity.class);
                break;
            case R.id.btn2:
                intent.setClass(MainActivity.this, SlideCustomActivity.class);
                break;
            case R.id.btn3:
                intent.setClass(MainActivity.this, SlideCropActivity.class);
                break;
            case R.id.btn4:
                intent.setClass(MainActivity.this, CustomSlideActivity.class);
                break;
            case R.id.btn5:
                intent.setClass(MainActivity.this, DrawerBasicActivity.class);
                break;
            case R.id.btn6:
                intent.setClass(MainActivity.this, DrawerFragmentActivity.class);
                break;
        }
        startActivity(intent);
    }
}
