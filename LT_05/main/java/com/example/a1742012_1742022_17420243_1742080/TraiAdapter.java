package com.example.a1742012_1742022_17420243_1742080;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TraiAdapter extends BaseAdapter {
    Context context;
    String names[];
    int hinh[];
    LayoutInflater inflter;

    public TraiAdapter(Context applicationContext, String[] names, int[] hinh) {
        this.context = context;
        this.names = names;
        this.hinh = hinh;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return hinh.length;
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
        view = inflter.inflate(R.layout.style_trai, null);
        TextView country = (TextView) view.findViewById(R.id.txtMaSoStyle);
        ImageView icon = (ImageView) view.findViewById(R.id.imgHinhStyle);
        country.setText(names[i]);
        icon.setImageResource(hinh[i]);
        return view;
    }
}
