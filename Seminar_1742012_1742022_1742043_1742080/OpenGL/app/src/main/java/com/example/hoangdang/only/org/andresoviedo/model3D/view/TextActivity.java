package com.example.hoangdang.only.org.andresoviedo.model3D.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.opengl.R;


public class TextActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Bundle b = getIntent().getExtras();
        String title = b.getString("title");
        setTitle(title);

//        String value = b.getString("text");
//        text = findViewById(R.id.);
//        text.setMovementMethod(LinkMovementMethod.getInstance());
//        text.setText(value);
    }
}
