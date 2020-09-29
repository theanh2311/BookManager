package com.example.du_an_mau_lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.DAO.NguoiDungDao;
import com.example.du_an_mau_lab.model.ListNguoiDungActivity;
import com.example.du_an_mau_lab.model.NguoiDung;


public class DetailNguoiDungActivity extends AppCompatActivity {
EditText edtPhone,edtFullName;
NguoiDungDao nguoiDungDao;
Button btnUpdate,btnCancel;
String phone,hoten,password,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sửa Thông Tin");
        setContentView(R.layout.activity_edit_info);
        edtFullName = findViewById(R.id.edt_Fullname_edit);
        edtPhone = findViewById(R.id.edtPhone_edit);
        btnCancel = findViewById(R.id.btn_CancelEdit);
        btnUpdate = findViewById(R.id.btnUpdate);
        nguoiDungDao=new NguoiDungDao(DetailNguoiDungActivity.this);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        phone = b.getString("phone");
        hoten = b.getString("hoten");
        username = b.getString("username");
        password = b.getString("password");
        edtPhone.setText(phone);
        edtFullName.setText(hoten);

    }

    public void updateUser(View view) {
        NguoiDung n = new NguoiDung();
        n.setUsername(username);
        n.setPhone(edtPhone.getText().toString());
        n.setHoten(edtFullName.getText().toString());
        n.setPassword(password);
        int kq = nguoiDungDao.updateUser(n);
        if (kq<=0){
    Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_SHORT).show();

}else {
    Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(DetailNguoiDungActivity.this, ListNguoiDungActivity.class);
    startActivity(intent);
}
    }

    public void Huy(View view) {
        finish();
    }
}