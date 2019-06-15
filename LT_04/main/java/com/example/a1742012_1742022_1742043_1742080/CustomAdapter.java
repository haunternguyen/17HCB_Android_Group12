package com.example.a1742012_1742022_1742043_1742080;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String countryList[];
    int flags[];
    int players[];
    String phoneList[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] countryList, int[] flags, int[] players, String[] phone) {
        this.context = context;
        this.countryList = countryList;
        this.flags = flags;
        this.players = players;
        this.phoneList = phone;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryList.length;
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
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
        TextView phone = (TextView) view.findViewById(R.id.txtPhone);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        ImageView icon2 = (ImageView) view.findViewById(R.id.icon2);
        country.setText(countryList[i]);
        phone.setText(phoneList[i]);
        icon.setImageResource(players[i]);
        icon2.setImageResource(flags[i]);
        return view;
    }
}