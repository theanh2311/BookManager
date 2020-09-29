package com.example.du_an_mau_lab.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.NguoiDungDao;
import com.example.du_an_mau_lab.DetailNguoiDungActivity;
import com.example.du_an_mau_lab.NguoiDungActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.adapter.NguoiDungAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListNguoiDungActivity extends AppCompatActivity {
    public static List<NguoiDung> lsND = new ArrayList<>();
    ListView lvNguoiDung;
    NguoiDungDao nguoiDungDao;
    NguoiDungAdapter ndAdapter;
    ImageView img;


    @Override
    protected void onResume() {
        super.onResume();
        lsND.clear();//xoa cai cu
        lsND = nguoiDungDao.getAllNguoiDung();//lay cai moi
        ndAdapter.changeDataset(lsND);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_user);
        lvNguoiDung = findViewById(R.id.lv_NguoiDung);
        nguoiDungDao = new NguoiDungDao(ListNguoiDungActivity.this);
        lsND = nguoiDungDao.getAllNguoiDung();
        ndAdapter = new NguoiDungAdapter(this, lsND);
        lvNguoiDung.setAdapter(ndAdapter);
        img = findViewById(R.id.imgAddUser);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i = new Intent(ListNguoiDungActivity.this, NguoiDungActivity.class);
                startActivity(i);
            }
        });

    }

}
