package com.example.a1742012_1742022_17420243_1742080;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentBlue extends Fragment {
    // this fragment shows a ListView
    MainActivity main;
    Context context = null;
    String message = "";
    // data to fill-up the ListView
    private String items[] = {"BAR", "LIV",
            "TOT", "JUV", "MAN",};
    private String names[] = {"BAR_10", "LIV_11",
            "TOT_10", "JUV_7", "MAN_19",};
    int hinh[] = {R.drawable.messi, R.drawable.salah, R.drawable.kane, R.drawable.ronaldo, R.drawable.sane};
    TextView txtBlue;
    private ListView mListView;

    // convenient constructor(accept arguments, copy them to a bundle, binds bundle to fragment)
    public static FragmentBlue newInstance(String strArg) {
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();

        } catch (IllegalStateException e) {
            throw new IllegalStateException(
                    "MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout layout_blue = (LinearLayout) inflater.inflate(R.layout.layout_blue, null);
        txtBlue = (TextView) layout_blue.findViewById(R.id.textView1Blue);
        final ListView listView = (ListView) layout_blue.findViewById(R.id.listView1Blue);
        mListView = (ListView) layout_blue.findViewById(R.id.listView1Blue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
//                android.R.layout.simple_list_item_1, names);
//        listView.setAdapter(adapter);
        // style ben trai
        Context context = getActivity();
        TraiAdapter customAdapter = new TraiAdapter(context, names, hinh);
        listView.setAdapter(customAdapter);


        listView.setSelection(0);
        listView.smoothScrollToPosition(0);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                main.onMsgFromFragToMain("BLUE-FRAG", String.valueOf(position));
                txtBlue.setText("Mã số: " + names[position]);

                for (int i = 0; i < listView.getChildCount(); i++) {
                    if (position == i) {
                        listView.getChildAt(i).setBackgroundColor(Color.BLUE);
                    } else {
                        listView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
                }
            }
        });
        return layout_blue;
    }

    public void onMsgFromMainToFragment(String strValue) {
        txtBlue.setText("Mã số: " + names[Integer.parseInt(strValue)]);
        for (int i = 0; i < mListView.getChildCount(); i++) {
            if (Integer.parseInt(strValue) == i) {
                mListView.getChildAt(i).setBackgroundColor(Color.BLUE);
            } else {
                mListView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}
