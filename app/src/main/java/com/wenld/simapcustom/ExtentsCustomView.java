package com.wenld.simapcustom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.wenld.customviewsupport.CanvasAidUtils;
import com.wenld.customviewsupport.CustomView;

/**
 * <p/>
 * Author: 温利东 on 2017/2/6 15:16.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class ExtentsCustomView extends CustomView {
    Paint paintMain;

    RectF rectFMain;

    public ExtentsCustomView(Context context) {
        super(context);
    }

    public ExtentsCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 初始化 xml设置属性
    @Override
    public void initAttrs(AttributeSet attrs) {

    }

    // 初始化
    @Override
    public void initValue() {
        paintMain = new Paint();
        paintMain.setAntiAlias(true);
        paintMain.setStyle(Paint.Style.STROKE);

    }

    // 布局大小位置改变时  重设置矩阵
    @Override
    public void reset() {
        rectFMain = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(mCenterX, mCenterY, circleR / 2, paintMain);
//        CanvasAidUtils.set2DCoordinateLe(canvas);
//        canvas.translate(mWidth/2,mHeight/2);  // 移动画布
        CanvasAidUtils.draw3DCoordinateSpace(canvas);
//        CanvasAidUtils.setDrawAid(false);
//        super.onDraw(canvas);
    }
}
