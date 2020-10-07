package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.SachDao;
import com.example.du_an_mau_lab.model.ListSachActivity;
import com.example.du_an_mau_lab.model.Sach;

public class SachActivity extends AppCompatActivity {
 EditText edtMaSach,edtMaTL,edtTieuDe,edtTacGia,edtNXB,edtSoLuong;
 Button btnAdd,btnCancel;
 SachDao sachDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach_them);
        edtMaSach = findViewById(R.id.edtMaSach);
        edtMaTL = findViewById(R.id.edtMaTL);
        edtTieuDe = findViewById(R.id.edt_TieuDe);
        edtTacGia = findViewById(R.id.edt_TacGia);
        edtNXB = findViewById(R.id.edtNXB);
        edtSoLuong = findViewById(R.id.edtSoLuong);
        btnAdd = findViewById(R.id.btn_OK);
        btnCancel = findViewById(R.id.btn_Cancel_AddSach);
    }
    public void addSach(View view){
         sachDao = new SachDao(SachActivity.this);

        if (edtMaSach.getText().toString().isEmpty() || edtMaTL.getText().toString().isEmpty() || edtTieuDe.getText().toString().isEmpty()
         || edtTacGia.getText().toString().isEmpty() || edtNXB.getText().toString().isEmpty() || edtSoLuong.getText().toString().isEmpty()){
            Toast.makeText(this, "k de trong", Toast.LENGTH_SHORT).show();
            return;
        }
        Sach sach = new Sach(edtMaSach.getText().toString(),edtMaTL.getText().toString(),edtTieuDe.getText().toString(),
                edtTacGia.getText().toString(),edtNXB.getText().toString(),Integer.parseInt(edtSoLuong.getText().toString()));
        try {
            if (sachDao.insertSach(sach)>0){
                Toast.makeText(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SachActivity.this, ListSachActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getApplicationContext(),"Thêm Thất Bại",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Lỗi : ",e.toString());
        }
    }
    public void cancelAddSach(View view){
                //Intent intent = new Intent(TheLoaiActivity.this, ListTheLoaiActivity.class);
        finish();
    }
}
