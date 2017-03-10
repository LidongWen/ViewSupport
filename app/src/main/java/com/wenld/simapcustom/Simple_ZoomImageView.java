package com.wenld.simapcustom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wenld.simapcustom.view.zoomImage.ZoomImage01;

/**
 * <p/>
 * Author: 温利东 on 2017/2/15 14:37.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class Simple_ZoomImageView extends AppCompatActivity {
    private ZoomImage01 image_acitivty_zoom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_zoomimageview);
        initView();
        image_acitivty_zoom.setImageResource(R.mipmap.mylove);
    }

    private void initView() {
        image_acitivty_zoom = (ZoomImage01) findViewById(R.id.image_acitivty_zoom);
    }
}
