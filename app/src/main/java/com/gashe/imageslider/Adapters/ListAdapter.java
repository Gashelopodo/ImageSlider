package com.gashe.imageslider.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gashe.imageslider.Classes.Images;
import com.gashe.imageslider.R;

/**
 * Created by g5 on 16/3/17.
 */

public class ListAdapter extends BaseAdapter {

    private Context context;
    private Images[] images;

    public ListAdapter(Context context, Images[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View element;

        Activity activity = (Activity)context;
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        element = layoutInflater.inflate(R.layout.row_list, viewGroup, false);

        TextView textView = (TextView)element.findViewById(R.id.myTextList);
        if(images[i].getLike()) textView.setText("ME GUSTA");
        else if(images[i].getNolike()) textView.setText("NO ME GUSTA");

        ImageView imageView = (ImageView)element.findViewById(R.id.myImageList);
        imageView.setImageResource(images[i].getResId());

        return element;
    }
}
