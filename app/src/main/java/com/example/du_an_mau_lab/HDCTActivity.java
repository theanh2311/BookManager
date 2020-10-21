package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.HDCTDao;
import com.example.du_an_mau_lab.model.HDCT;
import com.example.du_an_mau_lab.model.ListHDCTActivity;


public class HDCTActivity extends AppCompatActivity {
    Button btnAddHDCT;
    HDCTDao hdctDao;
    EditText edtMaHoaDon,edtMaSanPham,edtSoLuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hdct);
        btnAddHDCT = findViewById(R.id.btn_addHDCT);
        edtMaHoaDon = findViewById(R.id.maHD);
        edtMaSanPham = findViewById(R.id.maSP);
        edtSoLuong = findViewById(R.id.soLuong);
    }
    public void addHDCT(View view){
        hdctDao = new HDCTDao(HDCTActivity.this);
        HDCT hdct = new HDCT(edtMaHoaDon.getText().toString(),edtMaSanPham.getText().toString(),edtSoLuong.getText().toString());
        try {
            if (hdctDao.insertHDCT(hdct)>0){
                Toast.makeText(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HDCTActivity.this, ListHDCTActivity.class);
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
        btn= findViewById(R.id.btn_cancel_addHDCT);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(TheLoaiActivity.this, ListTheLoaiActivity.class);
                finish();
            }
        });
    }
}
