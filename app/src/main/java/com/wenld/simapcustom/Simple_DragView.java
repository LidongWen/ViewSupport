package com.wenld.simapcustom;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.wenld.simapcustom.view.DragView;

/**
 * <p/>
 * Author: 温利东 on 2017/2/8 10:47.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class Simple_DragView extends Activity {
    private DragView drawView_;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_dragview);
        initView();
//        ViewGroup content = (ViewGroup) findViewById(android.R.id.content);
        drawView_.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    private void initView() {
        drawView_ = (DragView) findViewById(R.id.drawView_);
    }
}
