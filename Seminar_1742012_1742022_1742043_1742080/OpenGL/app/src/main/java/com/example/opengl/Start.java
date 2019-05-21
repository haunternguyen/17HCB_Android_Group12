package com.example.opengl;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.hoangdang.only.org.andresoviedo.model3D.view.ModelActivity;
import com.example.hoangdang.only.org.andresoviedo.util.android.AssetUtils;
import com.example.hoangdang.only.org.andresoviedo.util.android.ContentUtils;

import java.util.HashMap;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;

public class Start extends Activity implements View.OnClickListener {

    MediaPlayer mediaPlayer;
    private Map<String, Object> loadModelParameters = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.start);

//        Button b = (Button) findViewById(R.id.btnStart);
//        b.setOnClickListener(this);

        Button btnHighScore = (Button) findViewById(R.id.btnHighscore);
        btnHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.example.opengl.HighScore");
                startActivity(i);
            }
        });
        GifImageView emoji;
        emoji = (GifImageView) findViewById(R.id.imgIron);
        emoji.setOnClickListener(this);
//        Button btnPlay = (Button) findViewById(R.id.btnplay);
//        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.attention);
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.start();
//        }
//        });
//
//        Button btnStop = (Button) findViewById(R.id.btnStop);
//        btnStop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.pause();
//            }
//        });

        Button btnLoad3d = (Button) findViewById(R.id.btnLoadModel);
        btnLoad3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AssetUtils.createChooserDialog(Start.this, "Select file", null, "models", "(?i).*\\.(obj|stl|dae)",
                        (String file) -> {
                            if (file != null) {
                                ContentUtils.provideAssets(Start.this);
                                launchModelRendererActivity(Uri.parse("assets://" + getPackageName() + "/" + file));
                            }
                        });
            }
        });

        Button btnTutorial = (Button) findViewById(R.id.btnTutorial);
        btnTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.example.opengl.INSTRUCTIONS");
                startActivity(i);
            }
        });
    }

    private void launchModelRendererActivity(Uri uri) {
        Log.i("Menu", "Launching renderer for '" + uri + "'");
        Intent intent = new Intent(getApplicationContext(), ModelActivity.class);
        intent.putExtra("uri", uri.toString());
        intent.putExtra("immersiveMode", "true");

        // content provider case
        if (!loadModelParameters.isEmpty()) {
            intent.putExtra("type", loadModelParameters.get("type").toString());
            loadModelParameters.clear();
        }

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent("com.example.opengl.MAIN");
        startActivity(i);
    }

}


