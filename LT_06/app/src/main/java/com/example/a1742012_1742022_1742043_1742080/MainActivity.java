package com.example.a1742012_1742022_1742043_1742080;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {
    ProgressBar myBarHorizontal;
    TextView lblTopCaption;
    EditText txtDataBox;
    Button btnDoSomething;
    Button btnReset;
    double progressStep = 1;
    int SoLanLap = 0;
    final int MAX_PROGRESS = 100;
    int globalVar = 0;
    double accum = 0;
    long startingMills = System.currentTimeMillis();
    boolean isRunning = false;
    String PATIENCE = "Some important data is being collected now. "
            + "\nPlease be patient...wait...\n ";
    Handler myHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTopCaption = (TextView) findViewById(R.id.lblTopCaption);
        myBarHorizontal = (ProgressBar) findViewById(R.id.myBarHor);
        txtDataBox = (EditText) findViewById(R.id.txtBox1);
        txtDataBox.setHint("Nhập số: ");
        lblTopCaption.setText("progress: 0%");
        myBarHorizontal.setProgress(0);
        btnDoSomething = (Button) findViewById(R.id.btnDoSomething);
        btnDoSomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNumeric(txtDataBox.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Số không hợp lệ!", Toast.LENGTH_LONG).show();
                    return;
                }
                Integer number = Integer.parseInt(txtDataBox.getText().toString());
                if (number <= 0) {
                    Toast.makeText(MainActivity.this, "Số không hợp lệ!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    btnDoSomething.setEnabled(false);
                    // int ketqua = 100 % number;
                    double ketqua = 100.0 / number * 1.0;
                    SoLanLap = number;
//                    Toast.makeText(MainActivity.this, String.valueOf("step: " + ketqua), Toast.LENGTH_LONG).show();
                    progressStep = ketqua;

                    Thread myBackgroundThread = new Thread(backgroundTask, "backAlias1");
                    isRunning = true;
                    myBackgroundThread.start();
                }

//                Toast.makeText(MainActivity.this, "I’m quick - You said >> \n"
//                        + text, Toast.LENGTH_LONG).show();
            }// onClick
        });// setOnClickListener
    }// onCreate 4

    @Override
    protected void onStart() {
        super.onStart();
// prepare UI components
        txtDataBox.setText("");
// reset and show progress bars
        accum = 0;
        myBarHorizontal.setMax(MAX_PROGRESS);
        myBarHorizontal.setProgress(0);
        myBarHorizontal.setVisibility(View.VISIBLE);

    }

    private Runnable foregroundRunnable = new Runnable() {
        @Override
        public void run() {
            try {

                if (isRunning) {
                    lblTopCaption.setText("progress: " + (int) accum
                            + "%");
                    myBarHorizontal.setProgress((int) accum);
                    accum += progressStep;
                    if (accum > myBarHorizontal.getMax()) {
                        lblTopCaption.setText("Hết giờ");
                        myBarHorizontal.setProgress(0);
                        btnDoSomething.setEnabled(true);
                        accum = 0;
                        isRunning = false;
                    }
                }
            } catch (Exception e) {
                Log.e("<<foregroundTask>>", e.getMessage());
            }
        }
    }; // foregroundTask
    private Runnable backgroundTask = new Runnable() {
        @Override
        public void run() {
            try {
                for (int n = 0; accum <= myBarHorizontal.getMax(); n++) {
                    Thread.sleep(100);
                    globalVar++;

                    myHandler.post(foregroundRunnable);
                }
            } catch (InterruptedException e) {
                Log.e("<<foregroundTask>>", e.getMessage());
            }
        }// run
    };

    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
}
