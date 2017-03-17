package com.gashe.imageslider.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gashe.imageslider.Classes.Images;
import com.gashe.imageslider.Adapters.MyPageAdapter;
import com.gashe.imageslider.R;
import com.gashe.imageslider.Classes.Utils;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private MyPageAdapter myPageAdapter;
    private Images[] images = new Images[]{
            new Images(0, R.drawable.imgres0, false, false),
            new Images(1, R.drawable.imgres1, false, false),
            new Images(2, R.drawable.imgres2, false, false),
            new Images(3, R.drawable.imgres3, false, false),
            new Images(4, R.drawable.imgres3, false, false),
            new Images(5, R.drawable.imgres3, false, false),
            new Images(6, R.drawable.imgres3, false, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Guardamos las imagenes en sharedpreferences **/
        final SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean control = prefs.getBoolean("init", false);

        /** Verificamos si existe ya el sharedpreferences **/
        if(control == false) {
            Log.d(getClass().getCanonicalName(), "No existe");
            SharedPreferences.Editor editor = prefs.edit();
            for(int i = 0; i < images.length; i++){
                editor.putBoolean("like" + i, false);
                editor.putBoolean("nolike" + i, false);
            }
            editor.putInt("length", images.length);
            editor.putBoolean("init", true);
            editor.commit();
        }else{

            boolean exit;
            Utils utils = new Utils();
            exit = utils.checkLikes(prefs);

            if(exit) {
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        }

        viewPager = (ViewPager)findViewById(R.id.myViewPager);
        myPageAdapter = new MyPageAdapter(getSupportFragmentManager(), images, this);

        viewPager.setAdapter(myPageAdapter);


    }

    @Override
    public void onBackPressed() {

        viewPager = (ViewPager)findViewById(R.id.myViewPager);

        if((viewPager.getCurrentItem() - 1) >= 0){
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }else{
            super.onBackPressed();
        }

    }
}
