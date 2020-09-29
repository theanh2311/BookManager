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
import com.example.du_an_mau_lab.model.ListNguoiDungActivity;
import com.example.du_an_mau_lab.model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
Button btnThem,btnCancelThem;
NguoiDungDao nguoiDungDao;
EditText edtTkUser,edtPassUser,edtEmailUser,edtNameUser,edtBirthdayUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_user);
        setTitle("Thêm Người Dùng");
        edtBirthdayUser = findViewById(R.id.edtNameUser);
        edtTkUser = findViewById(R.id.edttk_User);
        edtEmailUser = findViewById(R.id.edtEmailUser);
        edtNameUser = findViewById(R.id.edtNameUser);
        edtPassUser = findViewById(R.id.edt_pass_user);
        btnThem = findViewById(R.id.btnThem_User);
    }
    public void cancelAddUser(View view){
        Button btn;
        btn= findViewById(R.id.btn_huy_them_user);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
    public void addUser(View view){
        nguoiDungDao = new NguoiDungDao(NguoiDungActivity.this);
        NguoiDung nguoiDung = new NguoiDung(edtTkUser.getText().toString(),edtPassUser.getText().toString(),
                edtEmailUser.getText().toString(),edtBirthdayUser.getText().toString(),edtNameUser.getText().toString());
        try {
            if (nguoiDungDao.insertNguoiDung(nguoiDung)>0){
                Toast.makeText(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NguoiDungActivity.this,ListNguoiDungActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Thêm Thất Bại",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Log.e("Lỗi : ",e.toString());
        }

    }
}