package com.wenld.simapcustom.view.mylargeImageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.wenld.customviewsupport.CustomView;

/**
 * <p/>
 * Author: wenld on 2017/5/5 14:58.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */

public class MyScaleView extends CustomView implements View.OnTouchListener{

    private int mDrawableWidth = 0;
    private int mDrawableHeight = 0;
    private Drawable mDrawable = null;
    /**
     * 缩放的手势检测
     */
    private ScaleGestureDetector mScaleGestureDetector = null;

    /**
     * 用于存放矩阵的9个值
     */
    private final float[] matrixValues = new float[9];
    private final Matrix mScaleMatrix = new Matrix();

    public void setImageDrawable(Drawable drawable) {
        if (mDrawable != drawable) {
            final int oldWidth = mDrawableWidth;
            final int oldHeight = mDrawableHeight;

            mDrawableWidth = drawable.getIntrinsicWidth();
            mDrawableHeight = drawable.getIntrinsicHeight();

            if (oldWidth != mDrawableWidth || oldHeight != mDrawableHeight) {
                requestLayout();
            }
            invalidate();
        }
    }

    public MyScaleView(Context context) {
        super(context);
    }

    @Override
    public void initAttrs(AttributeSet attrs) {

    }

    @Override
    public void initValue() {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector detector) {

                float scaleFactor = detector.getScaleFactor();

                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector detector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector detector) {
                // Intentionally empty
            }
        });
        this.setOnTouchListener(this);
    }

    @Override
    public void reset() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDrawable.draw(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        return true;
    }

}
