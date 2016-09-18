package com.arpitonline.androidui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arpitonline.androidui.com.arpitonline.androidui.customviewpager.CardsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true, new RotationTransformer());
        viewPager.setAdapter(new CardsPagerAdapter(this));


    }

    private static class RotationTransformer implements ViewPager.PageTransformer{

        @Override
        public void transformPage(View page, float position) {
            page.setTranslationY(Math.abs(position * 100));
            page.setRotation(position * 4);
            page.setRotationX(position * 4);
            page.setRotationY( Math.max( -20, position * 10 * -1));

        }
    }


}
