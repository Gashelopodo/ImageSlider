package com.gashe.imageslider.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.gashe.imageslider.Classes.Images;
import com.gashe.imageslider.Adapters.ListAdapter;
import com.gashe.imageslider.R;
import com.gashe.imageslider.Classes.Utils;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        int length = prefs.getInt("length", 0);
        Images[] images = new Images[length];
        int resId;
        boolean like;
        boolean nolike;


        for(int i = 0; i < length; i++){
            resId = getResources().getIdentifier("imgres" + i, "drawable", "com.gashe.imageslider");
            like = prefs.getBoolean("like" + i, false);
            nolike = prefs.getBoolean("nolike" + i, false);
            images[i] = new Images(i, resId, like, nolike);
        }

        Log.d(getClass().getCanonicalName(), "length: " + length);

        ListView listView = (ListView)findViewById(R.id.listView);
        ListAdapter listAdapter = new ListAdapter(this, images);
        listView.setAdapter(listAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, 1, 1, "Resetear Datos");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == 1){
            final SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);
            Utils utils = new Utils();
            utils.resetData(prefs);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return true;

    }
}
