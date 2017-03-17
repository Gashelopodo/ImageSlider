package com.gashe.imageslider.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.gashe.imageslider.Activities.ListActivity;
import com.gashe.imageslider.Classes.Utils;
import com.gashe.imageslider.R;

/**
 * Created by g5 on 14/3/17.
 */

public class FragmentButtons extends Fragment implements View.OnClickListener{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buttons, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageButton buttonLike = (ImageButton)getView().findViewById(R.id.buttonLike);
        buttonLike.setOnClickListener(this);


        ImageButton buttonNoLike = (ImageButton)getView().findViewById(R.id.buttonNoLike);
        buttonNoLike.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        final SharedPreferences prefs = getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.myViewPager);

        switch (view.getId()){
            case R.id.buttonLike:
                    editor.putBoolean("like" + viewPager.getCurrentItem(), true);
                    editor.putBoolean("nolike" + viewPager.getCurrentItem(), false);
                break;
            case R.id.buttonNoLike:
                    editor.putBoolean("nolike" + viewPager.getCurrentItem(), true);
                    editor.putBoolean("like" + viewPager.getCurrentItem(), false);
                break;
            default: Log.d(getClass().getCanonicalName(), "No hay evento");
        }

        editor.commit();


        boolean exit;
        int length = prefs.getInt("length", 0);
        Utils utils = new Utils();
        exit = utils.checkLikes(prefs);

        if(exit) {
            Intent intent = new Intent(getContext(), ListActivity.class);
            startActivity(intent);
            getActivity().finish();
        }else{
            if(viewPager.getCurrentItem() + 1 <= viewPager.getAdapter().getCount()){
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }



    }
}
