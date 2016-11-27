package com.jht.administrator.slidenmenu;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

public class DrawerFragmentActivity extends AppCompatActivity {

    private LeftFragment leftFragment;
    private RightFragment rightFragment;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_drawer_fragment);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        initView();
    }

    private void initView(){
        leftFragment = new LeftFragment();
        getFragmentManager().beginTransaction().replace(R.id.left_menu,leftFragment).commit();
        rightFragment = new RightFragment();
        getFragmentManager().beginTransaction().replace(R.id.right_menu,rightFragment).commit();

    }

    public void open(View view) {

        switch (view.getId()) {
            case R.id.openleft:
                if (drawer.isDrawerOpen(Gravity.LEFT)){
                    drawer.closeDrawer(Gravity.LEFT);
                }else {
                    drawer.openDrawer(Gravity.LEFT);
                }

                break;
            case R.id.openright:
                if (drawer.isDrawerOpen(Gravity.RIGHT)){
                    drawer.closeDrawer(Gravity.RIGHT);
                }else {
                    drawer.openDrawer(Gravity.RIGHT);
                }

                break;
        }
    }
}
