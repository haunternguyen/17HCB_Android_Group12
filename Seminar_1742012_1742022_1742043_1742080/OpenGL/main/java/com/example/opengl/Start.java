package com.example.opengl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Start extends Activity implements View.OnClickListener {
    SharedPreferences sharedpreferences;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start);

        Button b = (Button) findViewById(R.id.btnStart);
        b.setOnClickListener(this);


        Button btnPlay = (Button) findViewById(R.id.btnplay);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.attention);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
        }
        });

        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
    }

    @Override
    public void onClick(View v) {
        sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0);

        SharedPreferences.Editor editor = sharedpreferences.edit();
        int SoCuoiCung = sharedpreferences.getInt("highScore", 0);
        SoCuoiCung++;
        editor.putInt("highScore", SoCuoiCung);
        editor.commit();

        int ketqua = sharedpreferences.getInt("highScore", 0);

        Toast.makeText(Start.this, String.valueOf(ketqua),
                Toast.LENGTH_LONG).show();


        Intent i = new Intent("com.example.opengl.INSTRUCTIONS");
        startActivity(i);
    }

}

