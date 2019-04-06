package com.example.a1742012_1742022_1742043_1742080;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView simpleList;
    String countryList[] = {"André Onana", "Matthijs de Ligt", "Nicolás Tagliafico", "Frenkie de Jong", "Dusan Tadic", "Hakim Ziyech"};
    String PhoneList[] = {"24", "4", "31", "21", "10", "22"};
    int flags[] = {R.drawable.cameroon, R.drawable.netherlands, R.drawable.arg, R.drawable.netherlands, R.drawable.croatia, R.drawable.morocco};
    int players[] = {R.drawable.onana, R.drawable.delight, R.drawable.tagliafico, R.drawable.dejong, R.drawable.tadic, R.drawable.ziyech};

    TextView txtSoloMsg;
    ImageView imageSelectedCar;
    Button btnBack;
    TextView txtNumber;

    Bundle myStateInfo;
    String MyState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags, players, PhoneList);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showBigImage(position);
            }
        });
    }

    private void showBigImage(int position) {
        Intent intent = new Intent(this, One_People.class);
        intent.putExtra("pos", position);
        this.startActivity(intent);
    }
}
