package com.jht.administrator.slidenmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SlideCustomActivity extends AppCompatActivity {
     SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_custom);
        menu = (SlidingMenu) findViewById(R.id.sm);

    }
}
