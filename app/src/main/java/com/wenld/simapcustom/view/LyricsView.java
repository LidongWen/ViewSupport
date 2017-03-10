package com.wenld.simapcustom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;

import com.wenld.customviewsupport.CustomView;
import com.wenld.customviewsupport.DensityUtils;

/**
 * 歌词渐变效果
 * <p/>
 * Author: 温利东 on 2017/2/8 14:05.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class LyricsView extends CustomView {

    private float mPercent = 50;
    private float MAX_PROGRESS = 100f;
    private int colorLeft = Color.WHITE;
    private int colorRight = Color.parseColor("#FFAF31");

    private String text = "你问我爱你有多深 我爱你有几分";

    private Rect textBouds;
    private Paint textPaint;


    public LyricsView(Context context) {
        super(context);
    }

    public LyricsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initAttrs(AttributeSet attrs) {

    }

    @Override
    public void initValue() {
        setDefaultWidth(100);
        textPaint = new Paint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);

        textBouds = new Rect();


    }

    @Override
    public void reset() {

    }

    float progressWidth;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        progressWidth = (mPercent / MAX_PROGRESS) * mWidth;

        textPaint.setColor(colorRight);
        textPaint.getTextBounds(text, 0, text.length(), textBouds);
        textPaint.setTextSize(DensityUtils.sp2px(getContext(), 20));
        Paint.FontMetrics fm = textPaint.getFontMetrics();
        canvas.save(Canvas.CLIP_SAVE_FLAG);
        canvas.clipRect(progressWidth, 0, mWidth, getMeasuredHeight());
        canvas.drawText(text, mCenterX, mCenterY - (fm.bottom - fm.top) / 2 - fm.top, textPaint);
        canvas.restore();

        // 渐变
        textPaint.setColor(colorLeft);
//        textPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.save(Canvas.CLIP_SAVE_FLAG);
        canvas.clipRect(0, 0, progressWidth, getMeasuredHeight());
        canvas.drawText(text, mCenterX, mCenterY - (fm.bottom - fm.top) / 2 - fm.top, textPaint);
        canvas.restore();
    }

    public void setPercent(int percent) {
        this.mPercent = percent;
        invalidate();
    }
}
