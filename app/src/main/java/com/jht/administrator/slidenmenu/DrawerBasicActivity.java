package com.jht.administrator.slidenmenu;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

public class DrawerBasicActivity extends AppCompatActivity {

    private ListView mLv;
    private DrawerLayout drawerLayout;
    private FrameLayout mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_basic);
        mLv = (ListView) findViewById(R.id.left_lv);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mContentLayout = (FrameLayout) findViewById(R.id.drawer_content);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    public void open(View view) {
        drawerLayout.openDrawer(mLv);
    }

}
