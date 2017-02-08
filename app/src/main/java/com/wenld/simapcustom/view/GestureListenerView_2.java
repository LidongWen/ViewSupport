package com.wenld.simapcustom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.wenld.customviewsupport.CustomView;

/**
 * <p/>
 * Author: 温利东 on 2017/2/8 11:09.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class GestureListenerView_2 extends CustomView {
    private String TAG="GestureListenerView_2";
    private Paint mPaint;

    private PointF start, end, control;

    GestureDetector mDetector;


    public GestureListenerView_2(Context context) {
        super(context);
    }

    public GestureListenerView_2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initAttrs(AttributeSet attrs) {

    }

    @Override
    public void initValue() {
        initLis();
        mDetector = new GestureDetector(getContext(), listener);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(60);

        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control = new PointF(0, 0);
    }

    @Override
    public void reset() {
        // 初始化数据点和控制点的位置
        start.x = mCenterX - 200;
        start.y = mCenterY;
        end.x = mCenterX + 200;
        end.y = mCenterY;
        control.x = mCenterX;
        control.y = mCenterY - 100;


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 根据触摸位置更新控制点，并提示重绘
//        control.x = event.getX();
//        control.y = event.getY();
//        invalidate();
//        return true;
        return mDetector.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制数据点和控制点
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        canvas.drawPoint(start.x, start.y, mPaint);
        canvas.drawPoint(end.x, end.y, mPaint);
        canvas.drawPoint(control.x, control.y, mPaint);

        // 绘制辅助线
        mPaint.setStrokeWidth(4);
        canvas.drawLine(start.x, start.y, control.x, control.y, mPaint);
        canvas.drawLine(end.x, end.y, control.x, control.y, mPaint);

        // 绘制贝塞尔曲线
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);

        Path path = new Path();

        path.moveTo(start.x, start.y);
        path.quadTo(control.x, control.y, end.x, end.y);

        canvas.drawPath(path, mPaint);
    }

    GestureDetector.OnGestureListener listener;

    private void initLis() {
        listener =
                new GestureDetector.OnGestureListener() {
                    @Override
                    public boolean onDown(MotionEvent e) {
                        control.x = e.getX();
                        control.y = e.getY();
                        invalidate();
                        return true;
                    }

                    @Override
                    public void onShowPress(MotionEvent e) {

                    }

                    @Override
                    public boolean onSingleTapUp(MotionEvent e) {
                        return false;
                    }

                    @Override
                    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                        control.x = e2.getX();
                        control.y = e2.getY();
                        invalidate();
                        return false;
                    }

                    @Override
                    public void onLongPress(MotionEvent e) {

                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                        return false;
                    }
                };
    }
}
