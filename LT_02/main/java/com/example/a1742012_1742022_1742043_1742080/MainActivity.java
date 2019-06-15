package com.example.a1742012_1742022_1742043_1742080;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = "dd/MM/yyyy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            EditText edittext = (EditText) findViewById(R.id.txtBirthday);
            edittext.setText(sdf.format(myCalendar.getTime()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Dong keyboard
        findViewById(R.id.relativeLayout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });


        Button button = (Button) findViewById(R.id.btnSignup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kiem tra password
                EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
                String Password = txtPassword.getText().toString();

                EditText txtRetype = (EditText) findViewById(R.id.txtRetype);
                String Retype = txtRetype.getText().toString();

                EditText txtBirthDay = (EditText) findViewById(R.id.txtBirthday);
                String BirthDay = txtBirthDay.getText().toString();

                EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
                String Username = txtUsername.getText().toString();

                if (!isValidDate(BirthDay) == true) {
                    Toast.makeText(MainActivity.this, "Sai định dạng dd/mm/yyyy", LENGTH_SHORT).show();
                    return;
                }

                if (Password.equals("") || Retype.equals("") || Username.equals("")) {
                    Toast.makeText(MainActivity.this, "Nhập thiếu thông tin", LENGTH_SHORT).show();
                    return;
                }
                if (!Password.equals(Retype)) {
                    Toast.makeText(MainActivity.this, "Sai mật khẩu", LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(MainActivity.this, "Đăng kí thành công!", LENGTH_SHORT).show();
                    return;
                }
            }
        });

        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Nhấn select", LENGTH_SHORT).show();

                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        Button btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
                EditText txtRetype = (EditText) findViewById(R.id.txtRetype);
                EditText txtBirthDay = (EditText) findViewById(R.id.txtBirthday);
                EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
                txtPassword.setText("");
                txtRetype.setText("");
                txtBirthDay.setText("");
                txtUsername.setText("");
            }
        });

        Button btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Đóng chương trình!", LENGTH_SHORT).show();
    }
}
