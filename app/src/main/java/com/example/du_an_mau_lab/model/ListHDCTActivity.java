package com.example.du_an_mau_lab.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.HDCTDao;
import com.example.du_an_mau_lab.DAO.HoaDonDao;
import com.example.du_an_mau_lab.HDCTActivity;
import com.example.du_an_mau_lab.HoaDonActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.adapter.HDCTAdapter;
import com.example.du_an_mau_lab.adapter.HoaDonAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListHDCTActivity extends AppCompatActivity {
    public static List<HDCT> lsHDCT =new ArrayList<>();
    ListView lvHDCT;
    HDCTDao hdctDao;
    HDCTAdapter hdctAdapter;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_hdct);
        lvHDCT = findViewById(R.id.lv_hdct);
        hdctDao = new HDCTDao(ListHDCTActivity.this);
        lsHDCT= hdctDao.getAllHDCT();
        hdctAdapter = new HDCTAdapter(this,lsHDCT);
        lvHDCT.setAdapter(hdctAdapter);
        img = findViewById(R.id.img_add_hdct);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListHDCTActivity.this, HDCTActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        lsHDCT.clear();//xoa cai cu
        lsHDCT= hdctDao.getAllHDCT();
        hdctAdapter.changeDataset(lsHDCT);
    }
}
