package com.wenld.simapcustom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * <p/>
 * Author: 温利东 on 2017/2/15 14:26.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class ScrollLayout extends LinearLayout {
    private Scroller mScroller;
    private int mLastX;
    private int mLastY;

    public ScrollLayout(Context context) {
        this(context, null, 0);
    }

    public ScrollLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    int dy, dx, y, x;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getRawX();
        y = (int) event.getRawY();

        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                if (!mScroller.isFinished()) { // 如果上次的调用没有执行完就取消。
                    mScroller.abortAnimation();
                }
                mLastX = x;
                mLastY = y;
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                dy = y - mLastY;
                dx = x - mLastX;

                mLastX = x;
                mLastY = y;

                scrollBy(-dx, -dy);
                return true;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                // XY都从滑动的距离回去，最后一个参数是多少毫秒内执行完这个动作。
                mScroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), -getScrollY(), 1000);
                invalidate();
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    /**
     * 这个方法在调用了invalidate()后被回调。
     */
    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) { // 计算新位置，并判断上一个滚动是否完成。
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();// 再次调用computeScroll。
        }
    }
}
