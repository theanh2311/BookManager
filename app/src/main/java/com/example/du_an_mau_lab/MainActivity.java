package com.example.du_an_mau_lab;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.model.ListHDCTActivity;
import com.example.du_an_mau_lab.model.ListHoaDonActivity;
import com.example.du_an_mau_lab.model.ListSachActivity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.du_an_mau_lab.model.ListNguoiDungActivity;
import com.example.du_an_mau_lab.model.ListTheLoaiActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class MainActivity extends AppCompatActivity {
    ImageView imgNguoiDung, imgTheLoai,imgSach,imgHoaDon,imgHDCT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgNguoiDung = findViewById(R.id.imgNguoiDung);
        imgNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListNguoiDungActivity.class);
                startActivity(intent);
            }
        });
        imgTheLoai = findViewById(R.id.imgTheLoai);
        imgTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListTheLoaiActivity.class);
                startActivity(intent);
            }
        });
        imgSach = findViewById(R.id.imgSach);
        imgSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListSachActivity.class);
                startActivity(intent);
            }
        });
        imgHoaDon = findViewById(R.id.imgHoaDon);
        imgHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListHoaDonActivity.class);
                startActivity(intent);
            }
        });
        imgHDCT = findViewById(R.id.img_HDCT);
        imgHDCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListHDCTActivity.class);
                startActivity(intent);
            }
        });
    }
}
