package com.arpitonline.androidui.com.arpitonline.androidui.customviewpager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arpitonline.androidui.R;

import java.io.IOException;
import java.io.InputStream;

public class CardsPagerAdapter extends PagerAdapter {

    private Context mContext;

    private String[] movies = new String[]{"John_Wick.jpg", "captain_america.jpg", "enders_game.jpg", "edge_of_tomorrow.jpg"};

    public CardsPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.content_main, collection, false);
        ImageView img = (ImageView)layout.findViewById(R.id.image_view);
        img.setImageBitmap(getBitmapFromAssets(layout.getContext(), movies[position]));
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return movies.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return movies[position];
    }

    public Bitmap getBitmapFromAssets(Context context, String fileName) {
        AssetManager assetManager = context.getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }

}