package com.wenld.simapcustom.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.wenld.commontools.LogUtil;
import com.wenld.customviewsupport.CustomView;
import com.wenld.simapcustom.R;

/**
 * Created by wenld on 2017/2/26.
 * 多点触控实践
 */

public class DragView extends CustomView {
    String TAG = "DragView";
    Bitmap mBitmap;         // 图片
    RectF mBitmapRectF;     // 图片所在区域
    Matrix mBitmapMatrix;   // 控制图片的 matrix
    boolean canDrag = false;
    PointF lastPoint = new PointF(0, 0);
    Paint mDeafultPaint;

    public DragView(Context context) {
        super(context);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void initAttrs(AttributeSet attrs) {

    }

    @Override
    public void initValue() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.outWidth = 960 / 2;
        options.outHeight = 800 / 2;

        mDeafultPaint = new Paint();

        mBitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher_round, options);
        mBitmapRectF = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        mBitmapMatrix = new Matrix();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                // ▼ 判断是否是第一个手指 && 是否包含在图片区域内
                if (event.getPointerId(event.getActionIndex()) == 0 && mBitmapRectF.contains((int) event.getX(), (int) event.getY())) {
                    canDrag = true;
                    lastPoint.set(event.getX(), event.getY());
                }
                LogUtil.e(TAG, "ACTION_DOWN  getActionIndex():" + event.getActionIndex());
                LogUtil.e(TAG, "ACTION_DOWN  getPointerId():" + event.getPointerId(event.getActionIndex()));
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                // ▼ 判断是否是第一个手指
                if (event.getPointerCount()==1) {
                    canDrag = false;
                    mBitmapRectF = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
                    mBitmapMatrix.reset();
                    invalidate();
                }
                LogUtil.e(TAG, "ACTION_UP  getActionIndex():" + event.getActionIndex());
                LogUtil.e(TAG, "ACTION_UP  getPointerId():" + event.getPointerId(event.getActionIndex()));
                break;
            case MotionEvent.ACTION_MOVE:
//                LogUtil.e(TAG, "ACTION_MOVE  getActionIndex():" + event.getActionIndex());
                // 如果存在第一个手指，且这个手指的落点在图片区域内
                if (canDrag) {
                    // ▼ 注意 getX 和 getY
//                    int index = event.findPointerIndex(0);
//                    LogUtil.e(TAG, "ACTION_MOVE  event.findPointerIndex(0):" + event.findPointerIndex(0));
                    // Log.i(TAG, "index="+index);
                    mBitmapMatrix.postTranslate(event.getX(0) - lastPoint.x, event.getY(0) - lastPoint.y);
                    lastPoint.set(event.getX(0), event.getY(0));

//                    mBitmapRectF = new RectF(0,0,mBitmap.getWidth(), mBitmap.getHeight());
                    mBitmapMatrix.mapRect(mBitmapRectF);

                    invalidate();
                }
                break;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, mBitmapMatrix, mDeafultPaint);
    }

    @Override
    public void reset() {

    }
}
