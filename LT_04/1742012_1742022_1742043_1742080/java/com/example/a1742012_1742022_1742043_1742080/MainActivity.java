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
//                Toast.makeText(MainActivity.this, String.valueOf(position),
//                        Toast.LENGTH_LONG).show();
                showBigImage(position);
            }
        });
    }

    private void showBigImage(int position) {
        setContentView(R.layout.solo_people);
        txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
        imageSelectedCar = (ImageView) findViewById(R.id.imgSoloPhoto);
        txtNumber = (TextView) findViewById(R.id.txtNumber);
        txtNumber.setText(String.valueOf(PhoneList[position]));
        txtSoloMsg.setText(String.valueOf(countryList[position]));
        imageSelectedCar.setImageResource(players[position]);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreate(myStateInfo);
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//
////        int a = this.getWindow().getDecorView().findViewById(android.R.id.content).getId();
////        Toast.makeText(MainActivity.this, String.valueOf(a),
////                Toast.LENGTH_LONG).show();
////        Intent intent = new Intent(this, MainActivity.class);
////        startActivity(intent);
//        finish();
//    }
}
