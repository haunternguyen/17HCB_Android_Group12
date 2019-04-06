package com.example.opengl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Start extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start);

        Button b = (Button) findViewById(R.id.btnStart);
        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent("com.example.opengl.INSTRUCTIONS");
        startActivity(i);
    }

}

