package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.TheLoaiDao;
import com.example.du_an_mau_lab.model.ListTheLoaiActivity;
import com.example.du_an_mau_lab.model.TheLoai;

public class DetailTheLoaiActivity extends AppCompatActivity {
    EditText edtTenTL,edtMoTa,edtViTri;
    Button btnOK,btnCancel;
    TheLoaiDao theLoaiDao;
    String maTL,tenTL,moTa,vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sửa Thể Loại");
        setContentView(R.layout.activity_theloai_sua);
        theLoaiDao = new TheLoaiDao(DetailTheLoaiActivity.this);
        edtTenTL = findViewById(R.id.edtMaTL);
        edtMoTa = findViewById(R.id.edt_TieuDe);
        edtViTri = findViewById(R.id.edt_TacGia);
        btnCancel = findViewById(R.id.btn_Cancel_AddSach);
        btnOK = findViewById(R.id.btn_OK);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        maTL = b.getString("maTL");
        tenTL = b.getString("tenTL");
        moTa = b.getString("moTa");
        vitri = b.getString("vitri");
        edtViTri.setText(vitri);
        edtMoTa.setText(moTa);
        edtTenTL.setText(tenTL);
    }
    public void updateTL(View view){
        TheLoai t= new TheLoai();
        t.setMaTL(maTL);
        t.setTenTL(edtTenTL.getText().toString());
        t.setMoTa(edtMoTa.getText().toString());
        t.setViTri(edtViTri.getText().toString());
        int kq = theLoaiDao.updateTL(t);
        if (kq<=0){
            Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetailTheLoaiActivity.this, ListTheLoaiActivity.class);
            startActivity(intent);
        }
    }
    public void Huy(View view) {
        finish();
    }
}
