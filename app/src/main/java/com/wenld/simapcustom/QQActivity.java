package com.wenld.simapcustom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wenld.simapcustom.view.DraggableFlagView;

/**
 * <p/>
 * Author: 温利东 on 2017/2/16 15:54.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class QQActivity extends AppCompatActivity implements DraggableFlagView.OnDraggableFlagViewListener, View.OnClickListener{
    private DraggableFlagView draggableFlagView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq);
        findViewById(R.id.main_btn).setOnClickListener(this);

        draggableFlagView = (DraggableFlagView) findViewById(R.id.main_dfv);
        draggableFlagView.setOnDraggableFlagViewListener(this);
        draggableFlagView.setText("7");


    }


    @Override
    public void onFlagDismiss(DraggableFlagView view) {
        Toast.makeText(this, "onFlagDismiss", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn:
                draggableFlagView.setText("7");
                break;
        }
    }
}
