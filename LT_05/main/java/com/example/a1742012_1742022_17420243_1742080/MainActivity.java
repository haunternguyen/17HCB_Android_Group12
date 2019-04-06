package com.example.a1742012_1742022_17420243_1742080;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity implements MainCallbacks {

    FragmentTransaction ft;
    FragmentRed redFragment;
    FragmentBlue blueFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// create a new BLUE fragment - show it
        ft = getFragmentManager().beginTransaction();
        blueFragment = FragmentBlue.newInstance("first-blue");
        ft.replace(R.id.main_holder_blue, blueFragment);
        ft.commit();
// create a new RED fragment - show it
        ft = getFragmentManager().beginTransaction();
        redFragment = FragmentRed.newInstance("first-red");
        ft.replace(R.id.main_holder_red, redFragment);
        ft.commit();
    }

    @Override
    public void onMsgFromFragToMain(String sender, String strValue) {
// show message arriving to MainActivity
//        Toast.makeText(getApplication(),
//                " MAIN GOT>> " + sender + "\n" + strValue, Toast.LENGTH_LONG)
//                .show();
        if (sender.equals("RED-FRAG")) {
            try {
// forward blue-data to redFragment using its callback method
                blueFragment.onMsgFromMainToFragment(strValue);
            } catch (Exception e) {
                // Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }


        }
        if (sender.equals("BLUE-FRAG")) {
            try {
// forward blue-data to redFragment using its callback method
                redFragment.onMsgFromMainToFragment(strValue);
            } catch (Exception e) {
                // Log.e("ERROR", "onStrFromFragToMain " + e.getMessage());
            }
        }
    }
}
