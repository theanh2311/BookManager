package com.example.du_an_mau_lab.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.du_an_mau_lab.DAO.TheLoaiDao;
import com.example.du_an_mau_lab.R;
import com.example.du_an_mau_lab.TheLoaiActivity;
import com.example.du_an_mau_lab.adapter.TheLoaiAdapter;
import java.util.ArrayList;
import java.util.List;
public class ListTheLoaiActivity extends AppCompatActivity {
    public static List<TheLoai> lsTL =new ArrayList<>();
    ListView lvTheLoai;
    TheLoaiDao theLoaiDao;
    TheLoaiAdapter theLoaiAdapter;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv_the_loai);
        lvTheLoai = findViewById(R.id.lv_the_loai);
        theLoaiDao = new TheLoaiDao(ListTheLoaiActivity.this);
        lsTL= theLoaiDao.getAllTheLoai();
        theLoaiAdapter = new TheLoaiAdapter(this,lsTL);
        lvTheLoai.setAdapter(theLoaiAdapter);
        img = findViewById(R.id.img_add_TL);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListTheLoaiActivity.this, TheLoaiActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        lsTL.clear();//xoa cai cu
        lsTL= theLoaiDao.getAllTheLoai();
        theLoaiAdapter.changeDataset(lsTL);
    }
}
