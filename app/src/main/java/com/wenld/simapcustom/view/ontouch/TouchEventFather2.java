package com.wenld.simapcustom.view.ontouch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class TouchEventFather2 extends LinearLayout {

	public TouchEventFather2(Context context) {
		super(context);
	}

	public TouchEventFather2(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.e("sunzn", "TouchEventFather2 | dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
		return super.dispatchTouchEvent(ev);
	}

	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.i("sunzn", "TouchEventFather2 | onInterceptTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
//		return super.onInterceptTouchEvent(ev);
		return super.onInterceptTouchEvent(ev);
	}

	public boolean onTouchEvent(MotionEvent ev) {
		Log.d("sunzn", "TouchEventFather2 | onTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
		return super.onTouchEvent(ev);
	}

}
