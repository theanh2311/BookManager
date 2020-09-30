package com.example.du_an_mau_lab.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.du_an_mau_lab.model.NguoiDung;
import com.example.du_an_mau_lab.database.DatabaseHelper;
import com.example.du_an_mau_lab.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiDao {
    private SQLiteDatabase db;
    private SQLiteOpenHelper dbhelper;
    public  static final String TAG = "TAG_THELOAI";
    public  static  final String TABLE_NAME = "TheLoai";
    public static  final String SQL_THE_LOAI = "CREATE TABLE TheLoai (" +
            " maTL text primary key," +
            " tenTL text," +
            "moTa text," +
            "viTri text );";
    public TheLoaiDao(Context context){
        dbhelper = new DatabaseHelper(context);
        db = dbhelper.getWritableDatabase();
    }

    public List<TheLoai> getAllTheLoai(){
        List<TheLoai> lsTL = new ArrayList<>();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            TheLoai tl = new TheLoai();
            tl.setMaTL(c.getString(0));
            tl.setTenTL(c.getString(1));
            tl.setMoTa(c.getString(2));
            tl.setViTri(c.getString(3));
            lsTL.add(tl);
            c.moveToNext();
        }
        c.close();
        return lsTL;
    }
    public  int insertTheLoai(TheLoai t){
        ContentValues values = new ContentValues();
        values.put("maTL",t.getMaTL());
        values.put("tenTL",t.getTenTL());
        values.put("moTa",t.getMoTa());
        values.put("vitri",t.getViTri());
        try{
            //excute insert
            if(db.insert(TABLE_NAME,null,values)<0){
                return -1;
            }
        }catch (Exception e){
            Log.e(TAG,e.toString());
        }
        return 1;
    }

    public  int updateTL(TheLoai t){
        ContentValues values = new ContentValues();
        values.put("maTL",t.getMaTL());
        values.put("tenTL",t.getTenTL());
        values.put("moTa",t.getMoTa());
        values.put("vitri",t.getViTri());
        int kq = db.update(TABLE_NAME,values,"maTL=?",new String[]{t.getMaTL()});
        if (kq==0){
            return  -1;
        }
        return 1;
    }
    public int deleteTL(String maTL){
        int kq = db.delete(TABLE_NAME,"maTL=?",new String[]{maTL});
        if (kq==0){
            return -1;//xoa khong thanh cong
        }
        return  1;//xoa thanh cong
    }


}
