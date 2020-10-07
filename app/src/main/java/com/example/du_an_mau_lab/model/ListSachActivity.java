package com.example.du_an_mau_lab.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.SachDao;
import com.example.du_an_mau_lab.MainActivity;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.SachActivity;
import com.example.du_an_mau_lab.adapter.SachAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListSachActivity extends AppCompatActivity {
    ListView lvSach;
    SachDao sachDao;
    SachAdapter sachAdapter;
    ImageView img;
    public static List<Sach> lsS =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_sach);
    lvSach = findViewById(R.id.lv_sach);
    sachDao = new SachDao(ListSachActivity.this);
    lsS = sachDao.getAllSach();
        sachAdapter = new SachAdapter(this,lsS);
        lvSach.setAdapter(sachAdapter);
        img = findViewById(R.id.btn_OK);
        img.setOnClickListener(v -> {
            Intent intent = new Intent(ListSachActivity.this, SachActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        lsS.clear();//xoa cai cu
        lsS= sachDao.getAllSach();
        sachAdapter.changeDataset(lsS);
    }
}
