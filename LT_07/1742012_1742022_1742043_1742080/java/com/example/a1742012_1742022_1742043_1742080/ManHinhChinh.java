package com.example.a1742012_1742022_1742043_1742080;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ManHinhChinh extends AppCompatActivity {

    TextView txtThanhNien;
    TextView txtDanTri;
    TextView txtVNEXPRESS;
    TextView txtBongDa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_man_hinh_chinh);

        txtThanhNien = (TextView) this.findViewById(R.id.txtThanhNien);
        txtThanhNien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] myUrlCaptionMenu = {
                        {"https://thanhnien.vn/rss/home.rss", "Trang chủ"},
                        {"https://thanhnien.vn/rss/viet-nam.rss", "Thời sự"},
                        {"https://thethao.thanhnien.vn/rss/bong-da-viet-nam.rss", "Thể thao"},
                        {"https://thanhnien.vn/rss/the-gioi.rss", "Thế giới"},
                        {"https://thanhnien.vn/rss/van-hoa-nghe-thuat.rss", "Văn hóa"},
                        {"https://thanhnien.vn/rss/kinh-doanh.rss", "Kinh doanh"},
                        {"https://thanhnien.vn/rss/the-gioi-tre.rss", "Giới trẻ"},
                        {"https://thanhnien.vn/rss/giao-duc.rss", "Giáo dục"},
                };
                Intent callShowMain = new Intent(ManHinhChinh.this, MainActivity.class);
                Bundle myData = new Bundle();
                myData.putSerializable("list", myUrlCaptionMenu);
                myData.putString("channel", "CHANNELS IN THANH NIÊN");
                callShowMain.putExtras(myData);
                startActivity(callShowMain);
            }
        });
        txtVNEXPRESS = (TextView) this.findViewById(R.id.txtVNEXPRESS);
        txtVNEXPRESS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] myUrlCaptionMenu = {
                        {"https://vnexpress.net/rss/tin-moi-nhat.rss", "Trang chủ"},
                        {"https://vnexpress.net/rss/thoi-su.rss", "Thời sự"},
                        {"https://vnexpress.net/rss/the-thao.rss", "Thể thao"},
                        {"https://vnexpress.net/rss/the-gioi.rss", "Thế giới"},
                        {"https://vnexpress.net/rss/kinh-doanh.rss", "Kinh doanh"},
                        {"https://vnexpress.net/rss/khoa-hoc.rss", "Khoa học"},
                        {"https://vnexpress.net/rss/du-lich.rss", "Du lịch"},
                        {"https://vnexpress.net/rss/suc-khoe.rss", "Sức khỏe"},
                        {"https://vnexpress.net/rss/giao-duc.rss", "Giáo dục"},
                };
                Intent callShowMain = new Intent(ManHinhChinh.this, MainActivity.class);
                Bundle myData = new Bundle();
                myData.putSerializable("list", myUrlCaptionMenu);
                myData.putString("channel", "CHANELS IN VNEXPRESS");
                callShowMain.putExtras(myData);
                startActivity(callShowMain);
            }
        });
        txtDanTri = (TextView) this.findViewById(R.id.txtDANTRI);
        txtDanTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] myUrlCaptionMenu = {
                        {"https://www.24h.com.vn/upload/rss/trangchu24h.rss", "Trang chủ"},
                        {"https://www.24h.com.vn/upload/rss/tintuctrongngay.rss", "Tin tức trong ngày"},
                        {"https://www.24h.com.vn/upload/rss/bongda.rss", "Bóng đá"},
                        {"https://www.24h.com.vn/upload/rss/anninhhinhsu.rss", "An ninh - Hình sự"},
                        {"https://www.24h.com.vn/upload/rss/giaoducduhoc.rss", "Giáo dục - du học"},
                        {"https://www.24h.com.vn/upload/rss/canhacmtv.rss", "Ca nhạc - MTV"},
                        {"https://www.24h.com.vn/upload/rss/cuoi24h.rss", "Cười 24h"},
                        {"https://www.24h.com.vn/upload/rss/suckhoedoisong.rss", "Sức khỏe đời sống"},
                };
                Intent callShowMain = new Intent(ManHinhChinh.this, MainActivity.class);
                Bundle myData = new Bundle();
                myData.putSerializable("list", myUrlCaptionMenu);
                myData.putString("channel", "CHANELS IN 24h");
                callShowMain.putExtras(myData);
                startActivity(callShowMain);
            }
        });
        txtBongDa = (TextView) this.findViewById(R.id.txtBongDa);
        txtBongDa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] myUrlCaptionMenu = {
                        {"https://tuoitre.vn/rss/tin-moi-nhat.rss", "Tin nổi bật"},
                        {"https://tuoitre.vn/rss/the-gioi.rss", "Thế giới"},
                        {"https://tuoitre.vn/rss/kinh-doanh.rss", "Kinh doanh"},
                        {"https://tuoitre.vn/rss/nhip-song-so.rss", "Công nghệ"},
                        {"https://tuoitre.vn/rss/nhip-song-tre.rss", "Nhịp sống trẻ"},
                        {"https://tuoitre.vn/rss/giai-tri.rss", "Giải trí"},
                        {"https://tuoitre.vn/rss/giao-duc.rss", "Giáo dục"},
                        {"https://tuoitre.vn/rss/suc-khoe.rss", "Sức khỏe"},
                        {"https://tuoitre.vn/rss/thu-gian.rss", "Thư giản"},
                };
                Intent callShowMain = new Intent(ManHinhChinh.this, MainActivity.class);
                Bundle myData = new Bundle();
                myData.putSerializable("list", myUrlCaptionMenu);
                myData.putString("channel", "CHANELS IN TUOITRE");
                callShowMain.putExtras(myData);
                startActivity(callShowMain);
            }
        });
    }
}
