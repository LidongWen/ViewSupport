package com.wenld.simapcustom;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.wenld.simapcustom.viewPage.RotateDownPageTransformer;
import com.wenld.simapcustom.viewPage.ViewPagerCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * 学习代码
 * <p/>
 * Author: 温利东 on 2017/2/9 16:59.
 * blog: http://blog.csdn.net/sinat_15877283
 * github: https://github.com/LidongWen
 */

public class LargePhoneActivity extends Activity {
    private ViewPagerCompat mViewPager;
    private int[] mImgIds = new int[]{R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, /*R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher*/};
    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_large);

        initData();

        mViewPager = (ViewPagerCompat) findViewById(R.id.id_viewpager);
        mViewPager.setOffscreenPageLimit(mImgIds.length);
//        mViewPager.setPageTransformer(true, new DepthPageTransformer());
		mViewPager.setPageTransformer(true, new RotateDownPageTransformer());
//        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                container.addView(mImageViews.get(position));
                return mImageViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {

                container.removeView(mImageViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public int getCount() {
                return mImgIds.length;
            }
        });

    }

    private void initData() {
        for (int imgId : mImgIds) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            mImageViews.add(imageView);
        }
    }
}
