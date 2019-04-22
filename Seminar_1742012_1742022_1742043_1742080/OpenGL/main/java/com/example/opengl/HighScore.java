package com.example.opengl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class HighScore extends Activity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_highscore);

        sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        int SoCuoiCung = sharedpreferences.getInt("highScore", 0);

        TextView txtHighScore = (TextView) findViewById(R.id.txtScore);
        String chuoi = "" ;
        chuoi = String.valueOf(SoCuoiCung);
        txtHighScore.setText(chuoi);
//        txtHighScore.setText(SoCuoiCung);
        Log.e("So Cuoi Cung",chuoi);
    }
}
