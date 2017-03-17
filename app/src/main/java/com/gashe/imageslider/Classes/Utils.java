package com.gashe.imageslider.Classes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by g5 on 16/3/17.
 */

public class Utils {


    public boolean checkLikes(SharedPreferences prefs){

        boolean exit = true;
        int length = prefs.getInt("length", 0);
        for(int i = 0; i < length; i++){
            boolean like = prefs.getBoolean("like" + i, false);
            boolean nolike = prefs.getBoolean("nolike" + i, false);
            Log.d(getClass().getCanonicalName(), "like: "+like+" nolike: "+nolike);
            if(like == false && nolike == false) exit = false;
        }

        return exit;

    }


    public void resetData(SharedPreferences prefs){
        int length = prefs.getInt("length", 0);
        SharedPreferences.Editor editor = prefs.edit();
        for(int i = 0; i < length; i++){
            editor.putBoolean("like" + i, false);
            editor.putBoolean("nolike" + i, false);
        }
        editor.commit();
    }


}
