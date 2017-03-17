package com.gashe.imageslider.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.gashe.imageslider.Classes.Images;
import com.gashe.imageslider.R;
import com.gashe.imageslider.Fragments.ScreenPictureFragment;

/**
 * Created by g5 on 14/3/17.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {

    private Images[] images;
    private Context context;

    public MyPageAdapter(FragmentManager fm, Images[] images, Context context) {
        super(fm);
        this.images = images;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Activity activity = (Activity) context;
        Fragment fragment = null;
        ViewPager viewPager = (ViewPager)activity.findViewById(R.id.myViewPager);

        fragment = new ScreenPictureFragment(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return images.length;
    }

}
