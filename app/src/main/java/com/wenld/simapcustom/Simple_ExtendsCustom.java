package com.wenld.simapcustom;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

/**
 * <p/>
 * Author: 温利东 on 2017/2/8 10:47.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class Simple_ExtendsCustom extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_extends);
        ViewGroup content = (ViewGroup) findViewById(android.R.id.content);


    }
}
