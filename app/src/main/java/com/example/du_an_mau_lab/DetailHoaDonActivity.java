package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.HoaDonDao;
import com.example.du_an_mau_lab.model.HoaDon;
import com.example.du_an_mau_lab.model.ListHoaDonActivity;

public class DetailHoaDonActivity extends AppCompatActivity {
    EditText edtNgayMua;
    Button btnOK,btnCancel;
    HoaDonDao hoaDonDao;
    String maHoaDon,ngayMua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sửa Hóa Đơn");
        setContentView(R.layout.activity_hoadon_sua);
        hoaDonDao = new HoaDonDao(DetailHoaDonActivity.this);
        edtNgayMua = findViewById(R.id.edtNgayMua);
        btnCancel = findViewById(R.id.btn_cancel);
        btnOK = findViewById(R.id.btn_add);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        maHoaDon = b.getString("MaHoaDon");
        ngayMua = b.getString("NgayMua");
        edtNgayMua.setText(ngayMua);
    }
    public void updateHD(View view){
        HoaDon h= new HoaDon();
        h.setMaHoaDon(maHoaDon);
        h.setNgayMua(edtNgayMua.getText().toString());
        int kq = hoaDonDao.updateHD(h);
        if (kq<=0){
            Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetailHoaDonActivity.this, ListHoaDonActivity.class);
            startActivity(intent);
        }
    }
    public void Huy(View view) {
        finish();
    }
}
