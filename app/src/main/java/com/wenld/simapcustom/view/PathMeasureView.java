package com.wenld.simapcustom.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;

import com.wenld.customviewsupport.CustomView;

/**
 * Created by wenld on 2017/2/15.
 */

public class PathMeasureView extends CustomView {
    Path path;
    Path dst;
    Paint mDeafultPaint;

    float percent = 0.5f;
    float length;
    PathMeasure measure;

    public PathMeasureView(Context context) {
        super(context);
    }

    public PathMeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void initAttrs(AttributeSet attrs) {


    }

    private ValueAnimator mStartingAnimator;

    @Override
    public void initValue() {
        mDeafultPaint = new Paint();
        mDeafultPaint.setStyle(Paint.Style.STROKE);
        mDeafultPaint.setColor(Color.BLUE);
        mDeafultPaint.setStrokeWidth(15);
        mDeafultPaint.setStrokeCap(Paint.Cap.ROUND);
        mDeafultPaint.setAntiAlias(true);

        dst = new Path();
        path = new Path();
        path.addRect(-100, -100, 100, 100, Path.Direction.CW);  // 添加小矩形
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);  // 添加大矩形

        measure = new PathMeasure(path, false);         // 将 Path 与 PathMeasure  关联
        length = measure.getLength();


        ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                percent = (float) animation.getAnimatedValue();
                invalidate();
            }
        };

        Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // getHandle发消息通知动画状态更新
                mStartingAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        };

        mStartingAnimator = ValueAnimator.ofFloat(0, 1).setDuration(1000);
        mStartingAnimator.addUpdateListener(mUpdateListener);
        mStartingAnimator.addListener(mAnimatorListener);

        mStartingAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.translate(mWidth / 2, mHeight / 2);

        dst.reset();
        dst.lineTo(0, 0);
        mDeafultPaint.setColor(Color.RED);
        canvas.drawPath(path, mDeafultPaint);
        mDeafultPaint.setColor(Color.BLUE);

        measure.getSegment(0, length * percent, dst, true);                   // 截取一部分 并使用 moveTo 保持截取得到的 Path 第一个点的位置不变
        canvas.drawPath(dst, mDeafultPaint);

    }

    @Override
    public void reset() {

    }
}
