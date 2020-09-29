package com.example.du_an_mau_lab;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import androidx.appcompat.app.AppCompatActivity;

import com.example.du_an_mau_lab.model.ListNguoiDungActivity;
import com.example.du_an_mau_lab.model.ListTheLoaiActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            try {
                PackageInfo info = null;
                try {
                    info = getPackageManager().getPackageInfo("com.example.du_an_mau_lab", PackageManager.GET_SIGNATURES);
                }catch (PackageManager.NameNotFoundException e){
                    e.printStackTrace();
                }
                for (Signature signature : info.signatures){
                    MessageDigest md = MessageDigest.getInstance("SHA");
                    md.update(signature.toByteArray());
//                    Log.d("KeyHash: ", Base64.(md.digest(), android.util.Base64.DEFAULT));
                }
            }catch (NoSuchAlgorithmException e){

            }
    }
}
