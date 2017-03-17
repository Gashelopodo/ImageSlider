package com.gashe.imageslider.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gashe.imageslider.R;

/**
 * Created by g5 on 14/3/17.
 */

public class ScreenPictureFragment extends Fragment {

    private int position;

    public ScreenPictureFragment(int position) {
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View elemento;
        int resId = getResources().getIdentifier("imgres" + position, "drawable", "com.gashe.imageslider");

        elemento = inflater.inflate(R.layout.screen_picture_fragment, container, false);

        ImageView imageView = (ImageView)elemento.findViewById(R.id.myImageCustom);
        imageView.setImageResource(resId);

        return elemento;
    }

}
