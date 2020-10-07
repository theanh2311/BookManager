package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.SachDao;
import com.example.du_an_mau_lab.model.ListSachActivity;
import com.example.du_an_mau_lab.model.Sach;

public class DetailSachActivity extends AppCompatActivity {
    EditText edtMaTL,edtTieuDe,edtTacGia,edtSoLuong,edtNXB;
    SachDao sachDao;
    Button btnOK,btnCancel;
    String maTL,tieuDe,tacGia,soLuong,nxb,maSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sửa Sách");
        setContentView(R.layout.activity_sach_sua);
            sachDao = new SachDao(DetailSachActivity.this);
            edtMaTL = findViewById(R.id.edtMaTL);
            edtTieuDe = findViewById(R.id.edt_TieuDe);
            edtTacGia = findViewById(R.id.edt_TacGia);
            edtSoLuong = findViewById(R.id.edtSoLuong);
            edtNXB = findViewById(R.id.edtNXB);
            btnOK = findViewById(R.id.btn_OK);
            btnCancel = findViewById(R.id.btn_Cancel_AddSach);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        maTL=b.getString("maTL");
        tieuDe = b.getString("tieuDe");
        tacGia = b.getString("tacGia");
        soLuong = b.getString("soLuong");
        nxb = b.getString("NXB");
        edtMaTL.setText(maTL);
        edtTieuDe.setText(tieuDe);
        edtTacGia.setText(tacGia);
        edtSoLuong.setText(soLuong);
        edtNXB.setText(nxb);
        maSach = b.getString("maSach");
    }
    public void updateSach(View view){
        Sach s= new Sach();
        s.setMaSach(maSach);
        s.setMaTL(edtMaTL.getText().toString());
        s.setTieuDe(edtTieuDe.getText().toString());
        s.setTacGia(edtTacGia.getText().toString());
        s.setSoLuong(Integer.parseInt(edtSoLuong.getText().toString()));
        s.setNXB(edtNXB.getText().toString());
        int kq = sachDao.updateSach(s);
        if (kq<=0){
            Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetailSachActivity.this, ListSachActivity.class);
            startActivity(intent);
        }
    }
    public void Huy_add_sach(View view) {
        finish();
    }

}
