package com.example.opengl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.opengl.controls.ButtonControls;
import com.example.opengl.controls.SwipeControls;
import com.example.opengl.render.CommonUtil;
import com.example.opengl.render.OpenGlRenderer;
import com.example.opengl.render.SkyBoxRender;

public class MainActivity extends Activity {
    SharedPreferences sharedpreferences;
    private GLSurfaceView glSurfaceView;
    private boolean rendererSet = false;
    private SkyBoxRender skyboxRenderer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main_layout);

        GLSurfaceView glView = (GLSurfaceView) findViewById(R.id.glSurface);

//        final boolean supportsEs2 =
//                CommonUtil.checkIfSupportES2(this);
//
//        if (supportsEs2) {
//            initView();
//            initEvent();
//           //  setContentView(glView);
//        } else {
//            Toast.makeText(this, "This device does not support OpenGL ES 2.0.",
//                    Toast.LENGTH_LONG).show();
//            return;
//        }




        //==============
//        SkyBoxRender renderer = new SkyBoxRender(this);
        OpenGlRenderer renderer = new OpenGlRenderer();
        glView.setRenderer(renderer);

        glView.requestFocus();
        glView.setFocusableInTouchMode(true);

         GameStatus.init(this);
        glView.setOnTouchListener(new SwipeControls(this));

        Button b1 = (Button) findViewById(R.id.btnUp);
        Button b2 = (Button) findViewById(R.id.btnDown);
        Button b3 = (Button) findViewById(R.id.btnLeft);
        Button b4 = (Button) findViewById(R.id.btnRight);

        ButtonControls bc = new ButtonControls(this);
        b1.setOnTouchListener(bc);
        b2.setOnTouchListener(bc);
        b3.setOnTouchListener(bc);
        b4.setOnTouchListener(bc);

        final TextView tv = (TextView) findViewById(R.id.tvGameOver);
        Thread timer = new Thread() {
            private volatile boolean mIsStopped = false;
            @Override
            public void run() {
                super.run();
                int time = 0;
                while (!mIsStopped) {
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
                            if (GameStatus.isEnd()) {
                                mIsStopped = true;
                                sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", 0);

                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                int SoCuoiCung = sharedpreferences.getInt("highScore", 0);
                                Log.e("socuoi cung: " , String.valueOf(SoCuoiCung));
                                Log.e("temp: " , String.valueOf(temp));
                                if (SoCuoiCung < temp) {
                                    editor.putInt("highScore", temp);
                                    editor.commit();
                                }
                                tv.setText("GAME OVER :(");
                            } else {
                                tv.setText("Time: " + temp);
                            }
                        }
                    });
                }
            }
        };
        timer.start();
    }
    private void initView() {
        glSurfaceView = glSurfaceView = (GLSurfaceView) findViewById(R.id.glSurface);;
        glSurfaceView.setEGLContextClientVersion(2);

        skyboxRenderer = new SkyBoxRender(this);
        glSurfaceView.setRenderer(skyboxRenderer);
        rendererSet = true;
    }

    private void initEvent() {
        glSurfaceView.setOnTouchListener(new View.OnTouchListener() {
            float previousX, previousY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event != null) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        previousX = event.getX();
                        previousY = event.getY();
                    } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        final float deltaX = event.getX() - previousX;
                        final float deltaY = event.getY() - previousY;

                        previousX = event.getX();
                        previousY = event.getY();

                        glSurfaceView.queueEvent(new Runnable() {
                            @Override
                            public void run() {
                                skyboxRenderer.handleTouchDrag(
                                        deltaX, deltaY);
                            }
                        });
                    }

                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}

