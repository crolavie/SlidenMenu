package customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/11/8.
 */
public class CustomSlidingMenu extends HorizontalScrollView {

    private LinearLayout mWrapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private int mMenuRightPadding = 150;
    //菜单拖出来后，距离屏幕右侧的宽度，通过这个参数，可以达成屏幕适配

    private int mScreenWidth;//屏幕的宽度，即中间内容的宽度
    private int mMenuWidth;//菜单的宽度
    //判断菜单是否打开
    private boolean isOpen;
    //设置一个标志位，为了不重复测量
    private boolean once;

    public CustomSlidingMenu(Context context) {
        super(context);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public CustomSlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        setScrollBarSize(0);
        //获取屏幕的宽度
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        mScreenWidth = outMetrics.widthPixels;
    }

    public CustomSlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
//测量view的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!once){
            mWrapper = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) mWrapper.getChildAt(0);
            mContent = (ViewGroup) mWrapper.getChildAt(1);
            //计算menu的宽度
            mMenuWidth = mScreenWidth - mMenuRightPadding;
            mMenu.getLayoutParams().width = mMenuWidth;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }
    }
//最开始进去的时候，布局的排放方式
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed){
            this.scrollTo(mMenuWidth,0);
        }
    }
//获取手指触摸事件的方法
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //得到用户手势的状态
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_UP:
                //判断移动的宽度，然后决定影藏还是显示菜单
                int scrollx = getScrollX();
                if (scrollx>=mMenuWidth/2){
                    this.scrollTo(mMenuWidth,0);
                    isOpen = false;
                }else{
                    this.scrollTo(0,0);
                    isOpen = true;
                }
                return true;
        }

        return super.onTouchEvent(ev);
    }

    public void openMenu(){
        if (isOpen){
            return;
        }
        this.smoothScrollTo(0,0);
        isOpen =true;
    }
    public void closeMenu(){
        if (!isOpen)
        {
            return;
        }
        this.smoothScrollTo(mMenuWidth,0);
        isOpen = false;
    }
    public void toggle(){
        if (isOpen){
            closeMenu();
        }
        else
        {
            openMenu();
        }
    }
}
