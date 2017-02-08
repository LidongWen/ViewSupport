package com.wenld.simapcustom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import com.wenld.simapcustom.view.LyricsView;

/**
 * <p/>
 * Author: 温利东 on 2017/2/8 14:24.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class Simple_LyricsView extends AppCompatActivity {
    private SeekBar mSeekBar;
    LyricsView lyricsView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar_Lyrics);
        lyricsView= (LyricsView) findViewById(R.id.lyricsView);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lyricsView.setPercent(progress);
//                mWaveLoadingView.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
