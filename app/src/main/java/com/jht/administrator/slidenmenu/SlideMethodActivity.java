package com.jht.administrator.slidenmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SlideMethodActivity extends AppCompatActivity {
    private ListView lv;
    private String []colors = {"红色","绿色","黄色","粉色","蓝色","黑色","灰色"};
    private int[]colorRes = {R.color.red,R.color.green,R.color.yellow,
            R.color.colorAccent,R.color.blue,R.color.black,R.color.gray};
    private ArrayAdapter<String>adapter;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_method);
        layout = (RelativeLayout) findViewById(R.id.layout);
        final SlidingMenu menu = new SlidingMenu(this);
        //设置菜单的方向
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        //设置滑动的范围，是边缘的滑动margin，还是全屏幕都能滑动
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置滑动出来菜单的宽度
        menu.setBehindOffsetRes(R.dimen.behind_offset);
       //设置阴影部分的图片
        menu.setShadowDrawable(R.color.colorAccent);
        menu.setShadowWidth(3);
        //设置淡入淡出的效果
        menu.setFadeEnabled(true);
        menu.setFadeDegree(0.35f);

        //使slidenment附加到activity上
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);

        //设置左右滑动的菜单  左边是listview 右边是linelayout
        menu.setMenu(R.layout.slide_method_left);
        menu.setSecondaryMenu(R.layout.slide_method_right);
        menu.setSecondaryShadowDrawable(R.color.colorPrimary);
        menu.setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
            @Override
            public void onOpened() {
                Log.i("tag","---菜单被打开了--OnOpenedListener--");
            }
        });
        menu.setOnClosedListener(new SlidingMenu.OnClosedListener() {
            @Override
            public void onClosed() {
                Log.i("tag","---菜单被关闭了--OnClosedListener--");
            }
        });
      lv = (ListView) findViewById(R.id.method_lv);
      adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,colors);
      lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                layout.setBackgroundResource(colorRes[i]);
                //切换菜单的状态
                 menu.toggle();
            }
        });

    }
}
