package com.example.a1742012_1742022_1742043_1742080;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    // Main GUI - A NEWS application based on National Public Radio RSS material
    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;
    // hard-coding main NEWS categories (TODO: use a resource file)
    String[][] myUrlCaptionMenu = {
//            {"https://vnexpress.net/rss/tin-moi-nhat.rss", "vnexpress"},
    };
    //define convenient URL and CAPTIONs arrays
    String[] myUrlCaption;
    String[] myUrlAddress;
    TextView txtTieuDe;
    String ChanelItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent callingIntent = getIntent();
        Bundle myBundle = callingIntent.getExtras();
        myUrlCaptionMenu = (String[][]) myBundle.getSerializable("list");
        myUrlCaption = new String[myUrlCaptionMenu.length];
        myUrlAddress = new String[myUrlCaptionMenu.length];
        txtTieuDe = (TextView) this.findViewById(R.id.txtTieuDe);


        ChanelItem = myBundle.getString("channel");

        txtTieuDe.setText(ChanelItem);
        this.setTitle(ChanelItem);
        for (int i = 0; i < myUrlCaptionMenu.length; i++) {
            myUrlAddress[i] = myUrlCaptionMenu[i][0];
            myUrlCaption[i] = myUrlCaptionMenu[i][1];
        }
        context = getApplicationContext();

// user will tap on a ListView’s row to request category’s headlines
        myMainListView = (ListView) this.findViewById(R.id.myListView);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> _av, View _v,
                                    int _index, long _id) {
                String urlAddress = myUrlAddress[_index];
                String urlCaption = myUrlCaption[_index];
//create an Intent to talk to activity: ShowHeadlines
                Intent callShowHeadlines = new Intent(MainActivity.this,
                        ShowHeadlines.class);
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                Toast.makeText(MainActivity.this,
                        urlCaption, Toast.LENGTH_LONG).show();
                switch (ChanelItem) {
                    case "CHANELS IN TUOITRE":
                        String TieuDeMoi = "ITEMS IN CHANNEL " + urlCaption +
                                " - " + " TUOITRE";
                        myData.putString("TieuDe", TieuDeMoi);
                        break;

                    case "CHANELS IN 24h":
                        String TieuDeMoi2 = "ITEMS IN CHANNEL " + urlCaption +
                                " - " + " 24h";
                        myData.putString("TieuDe", TieuDeMoi2);
                        break;

                    case "CHANELS IN VNEXPRESS":
                        String TieuDeMoi3 = "ITEMS IN CHANNEL " + urlCaption +
                                " - " + " VNEXPRESS";
                        myData.putString("TieuDe", TieuDeMoi3);
                        break;

                    case "CHANNELS IN THANH NIÊN":
                        String TieuDeMoi4 = "ITEMS IN CHANNEL " + urlCaption +
                                " - " + " THANH NIÊN";
                        myData.putString("TieuDe", TieuDeMoi4);
                        break;
                }

                callShowHeadlines.putExtras(myData);
                startActivity(callShowHeadlines);
            }
        });
// fill up the Main-GUI’s ListView with main news categories
        adapterMainSubjects = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);
    }

    public static String niceDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy ",
                Locale.US);
        return sdf.format(new Date());
    }
}
