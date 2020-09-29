package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.NguoiDungDao;
import com.example.du_an_mau_lab.DAO.TheLoaiDao;
import com.example.du_an_mau_lab.model.ListNguoiDungActivity;
import com.example.du_an_mau_lab.model.ListTheLoaiActivity;
import com.example.du_an_mau_lab.model.NguoiDung;
import com.example.du_an_mau_lab.model.TheLoai;

public class TheLoaiActivity extends AppCompatActivity {
    Button btnAddTL,btnCancelAddTL;
    TheLoaiDao theLoaiDao;
    EditText edtMaTL,edtTenTL,edtMoTaTL,edtViTriTL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theloai_them);
        btnAddTL = findViewById(R.id.btn_addTL);
        edtMaTL = findViewById(R.id.edtMaTL);
        edtTenTL = findViewById(R.id.edtTenTL);
        edtMoTaTL = findViewById(R.id.edt_MoTaTL);
        edtViTriTL = findViewById(R.id.edt_ViTriTL);
    }
    public void addTL(View view){
        theLoaiDao = new TheLoaiDao(TheLoaiActivity.this);
        TheLoai theLoai = new TheLoai(edtMaTL.getText().toString(),edtTenTL.getText().toString(),
                edtMoTaTL.getText().toString(),edtViTriTL.getText().toString());
        try {
            if (theLoaiDao.insertTheLoai(theLoai)>0){
                Toast.makeText(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TheLoaiActivity.this, ListTheLoaiActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Thêm Thất Bại",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Lỗi : ",e.toString());
        }
    }
    public void cancelAddTL(View view){
        Button btn;
        btn= findViewById(R.id.btn_Cancel_AddTL);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(TheLoaiActivity.this, ListTheLoaiActivity.class);
                finish();
            }
        });
    }
}
