package com.jht.administrator.slidenmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import customview.CustomSlidingMenu;

public class CustomSlideActivity extends AppCompatActivity {
    private CustomSlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_slide);
        menu = (CustomSlidingMenu) findViewById(R.id.csm);
    }

    public void change(View view) {
        menu.toggle();
    }
}
