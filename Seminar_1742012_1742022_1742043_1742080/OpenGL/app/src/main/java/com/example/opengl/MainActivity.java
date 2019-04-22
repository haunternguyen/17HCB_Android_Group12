package com.example.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.opengl.controls.ButtonControls;
import com.example.opengl.controls.SwipeControls;
import com.example.opengl.render.OpenGlRenderer;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main_layout);

        GLSurfaceView glView = (GLSurfaceView) findViewById(R.id.glSurface);
        OpenGlRenderer renderer = new OpenGlRenderer();
        glView.setRenderer(renderer);
        glView.requestFocus();
        glView.setFocusableInTouchMode(true);

        GameStatus.init(this);
//        glView.setOnTouchListener(new SwipeControls(this));
//
//        Button b1 = (Button) findViewById(R.id.btnUp);
//        Button b2 = (Button) findViewById(R.id.btnDown);
//        Button b3 = (Button) findViewById(R.id.btnLeft);
//        Button b4 = (Button) findViewById(R.id.btnRight);
//
//        ButtonControls bc = new ButtonControls(this);
//        b1.setOnTouchListener(bc);
//        b2.setOnTouchListener(bc);
//        b3.setOnTouchListener(bc);
//        b4.setOnTouchListener(bc);

        final TextView tv = (TextView) findViewById(R.id.tvGameOver);
        Thread timer = new Thread() {
            @Override
            public void run() {
                super.run();
                int time = 0;
                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    time++;
                    final int temp = time;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (GameStatus.isEnd())
                                tv.setText("GAME OVER :(");
                            else
                                tv.setText("Time: " + temp);
                        }
                    });
                }
            }
        };
        timer.start();
    }

}

