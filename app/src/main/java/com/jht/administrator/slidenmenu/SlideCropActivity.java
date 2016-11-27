package com.jht.administrator.slidenmenu;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class SlideCropActivity extends SlidingFragmentActivity {
    SlidingMenu menu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_crop);
        initMenu();
    }
    private void initMenu(){
        LeftFragment leftFragment = new LeftFragment();
        setBehindContentView(R.layout.leftlayout);
        getFragmentManager().beginTransaction().replace(R.id.left_layout,leftFragment).commit();
        menu = getSlidingMenu();
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeEnabled(true);
        menu.setFadeDegree(0.3f);
        menu.setShadowWidth(2);
        menu.setBehindOffsetRes(R.dimen.behind_offset);
        menu.setShadowDrawable(R.color.green);
        //设置右面滑动的菜单
        menu.setSecondaryMenu(R.layout.rightlayout);
        RightFragment rightFragment = new RightFragment();
        getFragmentManager().beginTransaction().replace(R.id.right_layout,rightFragment).commit();

    }
}
