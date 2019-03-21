package com.example.a1742012_1742022_1742043_1742080;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class One_People extends AppCompatActivity {

    private int pos;
    TextView txtSoloMsg;
    TextView txtNumber;
    ImageView imgSoloPhoto;
    Button btnBack;
    String countryList[] = {"André Onana", "Matthijs de Ligt", "Nicolás Tagliafico", "Frenkie de Jong", "Dusan Tadic", "Hakim Ziyech"};
    String PhoneList[] = {"24", "4", "31", "21", "10", "22"};
    int players[] = {R.drawable.onana, R.drawable.delight, R.drawable.tagliafico, R.drawable.dejong, R.drawable.tadic, R.drawable.ziyech};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one__people);

        Intent intent = this.getIntent();
        this.pos = intent.getIntExtra("pos", 0);

        txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
        txtSoloMsg.setText(countryList[pos]);

        txtNumber = (TextView) findViewById(R.id.txtNumber);
        txtNumber.setText(PhoneList[pos]);

        imgSoloPhoto = (ImageView) findViewById(R.id.imgSoloPhoto);
        imgSoloPhoto.setImageResource(players[pos]);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
    }

    public void backClicked(View view) {
        // Gọi phương thức onBackPressed().
        this.onBackPressed();
    }
}
