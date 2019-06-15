package com.example.a1742012_1742022_17420243_1742080;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a1742012_1742022_17420243_1742080.FragmentCallbacks;
import com.example.a1742012_1742022_17420243_1742080.MainActivity;
import com.example.a1742012_1742022_17420243_1742080.MainCallbacks;
import com.example.a1742012_1742022_17420243_1742080.R;

import java.util.Date;

public class FragmentRed extends Fragment implements FragmentCallbacks {
    MainActivity main;
    TextView txtRed;
    TextView txtMaSo;
    TextView txtHoTen;
    TextView txtLop;
    TextView txtDiemTrungBinh;
    Button btnFirst;
    Button btnLast;
    Button btnPrevious;
    Button btnNext;

    int ViTriHienTai = 0;

    private String Lop[] = {"BAR", "LIV",
            "TOT", "JUVE", "MAN",};
    private String Ten[] = {"Leo Messi", "Mohamed Salah",
            "Hary Kane", "Cristiano Ronaldo", "Leroy Sane",};
    private String Hoten[] = {"BAR_10", "LIV_11",
            "TOT_10", "JUV_7", "MAN_19",};
    private double DiemTrungBinh[] = {8.0, 7.0,
            6.0, 9.2, 2.3,};

    public static FragmentRed newInstance(String strArg1) {
        FragmentRed fragment = new FragmentRed();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException(" Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout view_layout_red = (LinearLayout) inflater.inflate(
                R.layout.layout_red, null);
        txtHoTen = (TextView) view_layout_red.findViewById(R.id.txtHoTen);
        txtLop = (TextView) view_layout_red.findViewById(R.id.txtLop);
        txtDiemTrungBinh = (TextView) view_layout_red.findViewById(R.id.txtDiemTrungBinh);
        try {
            Bundle arguments = getArguments();
            String redMessage = arguments.getString("arg1", "");
            txtMaSo = (TextView) view_layout_red.findViewById(R.id.txtMaSo);


        } catch (Exception e) {
            // Log.e("RED BUNDLE ERROR - ", "" + e.getMessage());
        }
        btnFirst = (Button) view_layout_red.findViewById(R.id.btnFirst);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain("RED-FRAG", "0");
                int pos = 0;
                txtMaSo.setText(Hoten[pos]);
                txtHoTen.setText("Họ tên: " + Ten[pos]);
                txtDiemTrungBinh.setText("Điểm trung bình: " + DiemTrungBinh[pos]);
                txtLop.setText("Lớp: " + Lop[pos]);
                ViTriHienTai = pos;
            }
        });

        btnLast = (Button) view_layout_red.findViewById(R.id.btnLast);
        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMsgFromFragToMain("RED-FRAG", "4");
                int pos = 4;
                txtMaSo.setText(Hoten[pos]);
                txtHoTen.setText("Họ tên: " + Ten[pos]);
                txtDiemTrungBinh.setText("Điểm trung bình: " + DiemTrungBinh[pos]);
                txtLop.setText("Lớp: " + Lop[pos]);

                ViTriHienTai = pos;
            }
        });

        btnPrevious = (Button) view_layout_red.findViewById(R.id.btnPrevious);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ViTriHienTai <= 0) {
                    main.onMsgFromFragToMain("RED-FRAG", "0");
                    int pos = 0;
                    txtMaSo.setText(Hoten[pos]);
                    txtHoTen.setText("Họ tên: " + Ten[pos]);
                    txtDiemTrungBinh.setText("Điểm trung bình: " + DiemTrungBinh[pos]);
                    txtLop.setText("Lớp: " + Lop[pos]);
                    ViTriHienTai = pos;
                } else {
                    main.onMsgFromFragToMain("RED-FRAG", String.valueOf(ViTriHienTai - 1));
                    int pos = ViTriHienTai - 1;
                    txtMaSo.setText(Hoten[pos]);
                    txtHoTen.setText("Họ tên: " + Ten[pos]);
                    txtDiemTrungBinh.setText("Điểm trung bình: " + DiemTrungBinh[pos]);
                    txtLop.setText("Lớp: " + Lop[pos]);
                    ViTriHienTai = pos;
                }

            }
        });

        btnNext = (Button) view_layout_red.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ViTriHienTai >= Hoten.length - 1) {
                    main.onMsgFromFragToMain("RED-FRAG", String.valueOf(Hoten.length - 1));
                    int pos = Hoten.length - 1;
                    txtMaSo.setText(Hoten[pos]);
                    txtHoTen.setText("Họ tên: " + Ten[pos]);
                    txtDiemTrungBinh.setText("Điểm trung bình: " + DiemTrungBinh[pos]);
                    txtLop.setText("Lớp: " + Lop[pos]);
                    ViTriHienTai = pos;
                } else {
                    main.onMsgFromFragToMain("RED-FRAG", String.valueOf(ViTriHienTai + 1));
                    int pos = ViTriHienTai + 1;
                    txtMaSo.setText(Hoten[pos]);
                    txtHoTen.setText("Họ tên: " + Ten[pos]);
                    txtDiemTrungBinh.setText("Điểm trung bình: " + DiemTrungBinh[pos]);
                    txtLop.setText("Lớp: " + Lop[pos]);
                    ViTriHienTai = pos;
                }

            }
        });
        return view_layout_red;
    }

    @Override
    public void onMsgFromMainToFragment(String strValue) {
        int pos = Integer.parseInt(strValue);
        txtMaSo.setText(Hoten[pos]);
        txtHoTen.setText("Họ tên: " + Ten[pos]);
        txtDiemTrungBinh.setText("Điểm trung bình: " + DiemTrungBinh[pos]);
        txtLop.setText("Lớp: " + Lop[pos]);
        ViTriHienTai = pos;
    }
}
