package com.example.du_an_mau_lab.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.HoaDonDao;
import com.example.du_an_mau_lab.DAO.TheLoaiDao;
import com.example.du_an_mau_lab.HoaDonActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.TheLoaiActivity;
import com.example.du_an_mau_lab.adapter.HoaDonAdapter;
import com.example.du_an_mau_lab.adapter.TheLoaiAdapter;
import java.util.ArrayList;
import java.util.List;

public class ListHoaDonActivity extends AppCompatActivity {
    public static List<HoaDon> lsHD =new ArrayList<>();
    ListView lvHoaDon;
    HoaDonDao hoaDonDao;
    HoaDonAdapter hoaDonAdapter;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_hoadon);
        lvHoaDon = findViewById(R.id.lv_hoadon);
        hoaDonDao = new HoaDonDao(ListHoaDonActivity.this);
        lsHD= hoaDonDao.getAllHoaDon();
        hoaDonAdapter = new HoaDonAdapter(this,lsHD);
        lvHoaDon.setAdapter(hoaDonAdapter);
        img = findViewById(R.id.img_add_HoaDon);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListHoaDonActivity.this, HoaDonActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        lsHD.clear();//xoa cai cu
        lsHD= hoaDonDao.getAllHoaDon();
        hoaDonAdapter.changeDataset(lsHD);
    }
}
