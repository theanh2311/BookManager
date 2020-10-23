package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.HDCTDao;
import com.example.du_an_mau_lab.model.HDCT;
import com.example.du_an_mau_lab.model.HoaDon;
import com.example.du_an_mau_lab.model.ListHDCTActivity;
import com.example.du_an_mau_lab.model.ListHoaDonActivity;

public class DetailHDCTActivity extends AppCompatActivity {
    EditText edtMaHoaDon,edtMaSanPham,edtSoLuong;
    Button btnOK,btnCancel;
    HDCTDao hdctDao;
    String maHoaDon;
    String maSanPham;
    String soLuong;
    String maHDCT;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sửa Hóa Đơn Chi Tiết");
        setContentView(R.layout.activity_hdct_sua);
        edtMaHoaDon = findViewById(R.id.maHD);
        edtMaSanPham = findViewById(R.id.maSP);
        edtSoLuong = findViewById(R.id.soLuong);
        btnCancel = findViewById(R.id.btn_cancel_addHDCT);
        btnOK = findViewById(R.id.btn_editHDCT);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        maHDCT= b.getString("MaHDCT");
        maHoaDon = b.getString("MaHoaDon");
        maSanPham = b.getString("MaSP");
        soLuong = b.getString("SoLuong");
        edtSoLuong.setText(soLuong);
        edtMaSanPham.setText(maSanPham);
        edtMaHoaDon.setText(maHoaDon);
       // Log.e("MSG"," "+maHDCT);
        hdctDao = new HDCTDao(this);
    }
    public void updateHDCT(View view){
        HDCT hdct= new HDCT();
        hdct.setMaHDCT(maHDCT);
        hdct.setMaHoaDon(edtMaHoaDon.getText().toString());
        hdct.setSoLuong(edtSoLuong.getText().toString());
        hdct.setMaSanPham(edtMaSanPham.getText().toString());
        int kq = hdctDao.updateHDCT(hdct);
        if (kq<=0){
            Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetailHDCTActivity.this, ListHDCTActivity.class);
            startActivity(intent);
        }
    }
    public void Huy(View view) {
        finish();
    }
}
