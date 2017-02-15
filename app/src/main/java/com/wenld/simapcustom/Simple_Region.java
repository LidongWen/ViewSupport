package com.wenld.simapcustom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wenld.simapcustom.view.matrix.CanvasVonvertTouchTest;

/**
 * <p/>
 * Author: 温利东 on 2017/2/8 10:49.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class Simple_Region extends AppCompatActivity {
    CanvasVonvertTouchTest canvasVonvert;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_region);
        canvasVonvert= (CanvasVonvertTouchTest) findViewById(R.id.canvasVonvert);

        canvasVonvert.setListener(new CanvasVonvertTouchTest.MenuListener() {
            @Override
            public void onCenterCliched() {
                canvasVonvert.setPadding(100,100,100,100);
//                canvasVonvert.requestLayout();
            }

            @Override
            public void onUpCliched() {

            }

            @Override
            public void onRightCliched() {

            }

            @Override
            public void onDownCliched() {

            }

            @Override
            public void onLeftCliched() {

            }
        });
    }
}
