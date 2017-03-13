package com.wenld.simapcustom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.wenld.simapcustom.view.ontouch.TouchEventUtil;

public class TouchEventActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ontouch);
	}

	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.w("sunzn", "TouchEventActivity | dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
		return super.dispatchTouchEvent(ev);
	}

	public boolean onTouchEvent(MotionEvent event) {
		Log.w("sunzn", "TouchEventActivity | onTouchEvent --> " + TouchEventUtil.getTouchAction(event.getAction()));
		return super.onTouchEvent(event);
	}

}