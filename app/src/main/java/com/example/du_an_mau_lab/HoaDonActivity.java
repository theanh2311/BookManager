package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.HoaDonDao;
import com.example.du_an_mau_lab.DAO.TheLoaiDao;
import com.example.du_an_mau_lab.model.HoaDon;
import com.example.du_an_mau_lab.model.ListHoaDonActivity;
import com.example.du_an_mau_lab.model.ListTheLoaiActivity;
import com.example.du_an_mau_lab.model.TheLoai;

public class HoaDonActivity extends AppCompatActivity {
    Button btnAddHD;
  HoaDonDao hoaDonDao;
    EditText edtMaHoaDon,edtNgayMua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadon_them);
        btnAddHD = findViewById(R.id.btn_add);
        edtMaHoaDon = findViewById(R.id.edtMaHoaDon);
        edtNgayMua = findViewById(R.id.edtNgayMua);
    }
    public void addHD(View view){
        hoaDonDao = new HoaDonDao(HoaDonActivity.this);
        HoaDon hoaDon = new HoaDon(edtMaHoaDon.getText().toString(),edtNgayMua.getText().toString());
        try {
            if (hoaDonDao.insertHoaDon(hoaDon)>0){
                Toast.makeText(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HoaDonActivity.this, ListHoaDonActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Thêm Thất Bại",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Lỗi : ",e.toString());
        }
    }
    public void cancelAddHD(View view){
        Button btn;
        btn= findViewById(R.id.btn_cancel);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(TheLoaiActivity.this, ListTheLoaiActivity.class);
                finish();
            }
        });
    }
}
